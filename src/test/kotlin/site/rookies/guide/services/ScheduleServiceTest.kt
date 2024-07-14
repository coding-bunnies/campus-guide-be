package site.rookies.guide.services

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import site.rookies.guide.entity.Schedule
import site.rookies.guide.repositories.ScheduleRepository
import java.time.LocalDateTime
import kotlin.test.assertEquals

@SpringBootTest
@Transactional
class ScheduleServiceTest {
    @Autowired
    lateinit var scheduleService: ScheduleService

    @Autowired
    lateinit var scheduleRepository: ScheduleRepository

    lateinit var schedule: Schedule

    @BeforeEach
    fun setUpTestData(): Unit {
        Schedule(
            startAt = LocalDateTime.of(2024, 6, 1, 0, 0, 0),
            endAt = LocalDateTime.of(2024, 7, 1, 0, 0, 0),
            description = "description"
        ).let { scheduleRepository.save(it) }
        schedule = Schedule(
            startAt = LocalDateTime.of(2024, 7, 1, 0, 0, 0),
            endAt = LocalDateTime.of(2024, 7, 14, 0, 0, 0),
            description = "description"
        ).let { scheduleRepository.save(it) }

        Schedule(
            startAt = LocalDateTime.of(2024, 7, 14, 0, 0, 0),
            endAt = LocalDateTime.of(2024, 8, 1, 0, 0, 0),
            description = "description"
        ).let { scheduleRepository.save(it) }

    }

    @Test
    fun listTest() {
        val list = scheduleService.list(2024, 7)

        assertEquals(1, list.size)
    }
}