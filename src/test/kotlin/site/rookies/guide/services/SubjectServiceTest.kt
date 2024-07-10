package site.rookies.guide.services

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import site.rookies.guide.dto.SubjectRequest
import site.rookies.guide.entity.Subject
import site.rookies.guide.repositories.SubjectRepository

@SpringBootTest
@Transactional
class SubjectServiceTest {
    @Autowired
    lateinit var subjectService: SubjectService

    @Autowired
    lateinit var subjectRepository: SubjectRepository

    lateinit var subject: Subject

    @BeforeEach
    fun setUpTestData(): Unit {
        subject = Subject(
            title = "Algorithm", credit = 3, professor = "professor", description = "description",
            outline = "outline", imageUrl = "imageUrl"
        ).let {
            subjectRepository.save(it)
        }
    }


    @Test
    fun listTest() {
        val subjectRequest = SubjectRequest(grade = 1, semester = 1, subjectTitle = "Algorithm")
        val subjects = subjectService.list(subjectRequest)
        assertEquals(1, subjects.size)
        assertEquals(subject.title, subjects[0].subjectTitle)
        assertEquals(subject.professor, subjects[0].professorName)
        assertEquals(subject.imageUrl, subjects[0].imageUrl)
    }

}