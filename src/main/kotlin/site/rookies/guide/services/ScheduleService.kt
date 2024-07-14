package site.rookies.guide.services

import org.springframework.stereotype.Service
import site.rookies.guide.dto.SchedulesDto
import site.rookies.guide.repositories.ScheduleQueryRepository
import java.time.LocalDateTime

@Service
class ScheduleService(
    private val scheduleQueryRepository: ScheduleQueryRepository
) {
    fun list(year: Int, month: Int): List<SchedulesDto> {
        val startAt = LocalDateTime.of(year, month, 1, 0, 0)
        val endAt = startAt.plusMonths(1).minusSeconds(1)
        val list = scheduleQueryRepository.findAll(startAt, endAt)

        return list.map {
            SchedulesDto(
                id = it.id,
                startAt = it.startAt,
                endAt = it.endAt,
                description = it.description
            )
        }
    }
}