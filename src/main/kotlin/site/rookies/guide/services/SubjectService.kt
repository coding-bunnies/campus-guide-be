package site.rookies.guide.services

import org.springframework.stereotype.Service
import site.rookies.guide.dto.SubjectDto
import site.rookies.guide.repositories.SubjectRepository

@Service
class SubjectService(private val subjectRepository: SubjectRepository) {
    fun list(grade:Int?, semester: Int?, subjectTitle:String?): List<SubjectDto> {
        val subjects = subjectRepository.findAll()
        return subjects.map { subject ->
            SubjectDto(
                id = subject.id,
                imageUrl = subject.imageUrl,
                subjectTitle = subject.title,
                professorName = subject.professor
            )
        }
    }
}