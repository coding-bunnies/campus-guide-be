package site.rookies.guide.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import site.rookies.guide.dto.ExamInfo
import site.rookies.guide.dto.SubjectDetailDto
import site.rookies.guide.dto.SubjectDto
import site.rookies.guide.dto.SubjectRequest
import site.rookies.guide.repositories.SubjectQueryRepository
import site.rookies.guide.repositories.SubjectRepository

@Service
class SubjectService(
    private val subjectRepository: SubjectRepository,
    private val subjectQueryRepository: SubjectQueryRepository) {
    fun list(subjectsRequest: SubjectRequest): List<SubjectDto> {
        val subjects = subjectQueryRepository.findAll(
            grade = subjectsRequest.grade,
            semester = subjectsRequest.semester,
            subjectTitle = subjectsRequest.subjectTitle
        )
        return subjects.map { subject ->
            SubjectDto(
                id = subject.id,
                imageUrl = subject.imageUrl,
                subjectTitle = subject.title,
                professorName = subject.professor
            )
        }
    }

    fun get(id: Int): SubjectDetailDto {
        val subject = subjectRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Subject not found")

        return SubjectDetailDto(
            subject = subject.title,
            grade = subject.grade,
            professorName = subject.professor,
            description = subject.description,
            outline = subject.outline,
            prerequisiteSubject = subject.prerequisiteSubject?.title,
            examInfo = ExamInfo(
                midtermExam = subject.midtermExam,
                finalExam = subject.finalExam,
                assignmentAvailable = subject.assignmentAvailable
            )
        )
    }
}