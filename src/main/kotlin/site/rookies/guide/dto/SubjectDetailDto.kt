package site.rookies.guide.dto

class SubjectDetailDto(
    val subject: String,
    val grade: Int,
    val professorName: String,
    val description: String,
    val outline: String,
    val prerequisiteSubject: String? = null,
    val examInfo: ExamInfo
)

class ExamInfo(
    val midtermExam: Boolean,
    val finalExam: Boolean,
    val assignmentAvailable: Boolean
)