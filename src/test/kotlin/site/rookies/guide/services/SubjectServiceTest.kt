package site.rookies.guide.services

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import site.rookies.guide.entity.Subject
import site.rookies.guide.repositories.SubjectRepository

@SpringBootTest
@Transactional
class SubjectServiceTest {
    @Autowired
    lateinit var subjectService: SubjectService

    @Autowired
    lateinit var subjectRepository: SubjectRepository

    @BeforeEach
    fun setUpTestData(): Unit {
        Subject(
            title = "title", credit = 1, professor = "professor", description = "description",
            outline = "outline", imageUrl = "imageUrl"
        ).let {
            subjectRepository.save(it)
        }
    }

    @Test
    fun listTest() {
        val subjects = subjectService.list(null, null, null)
        assertEquals(1, subjects.size)
    }

}