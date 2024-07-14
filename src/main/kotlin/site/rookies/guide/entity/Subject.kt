package site.rookies.guide.entity

import jakarta.persistence.*

@Entity
@Table(name = "subjects")
class Subject(
    title: String,
    credit: Int,
    professor: String,
    description: String,
    outline: String,
    imageUrl: String,
    grade: Int,
    semester: Int,
    midtermExam: Boolean,
    finalExam: Boolean,
    assignmentAvailable: Boolean,
    prerequisiteSubject: Subject? = null
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Int = 0

    @Column(name = "title", nullable = false, length = 64)
    var title: String = title
        protected set

    @Column(name = "credit", nullable = false)
    var credit: Int = credit
        protected set

    @Column(name = "professor", nullable = false, length = 32)
    var professor: String = professor
        protected set

    @Column(name = "description", nullable = false)
    var description: String = description
        protected set

    @Column(name = "outline", nullable = false, columnDefinition = "TEXT")
    var outline: String = outline
        protected set

    @Column(name = "image_url", nullable = false)
    var imageUrl: String = imageUrl
        protected set

    @Column(name = "grade", nullable = false)
    var grade: Int = grade
        protected set

    @Column(name = "semester", nullable = false)
    var semester: Int = semester
        protected set

    @Column(name = "midterm_exam", nullable = false)
    var midtermExam: Boolean = midtermExam
        protected set

    @Column(name = "final_exam", nullable = false)
    var finalExam: Boolean = finalExam
        protected set

    @Column(name = "assignment_available", nullable = false)
    var assignmentAvailable: Boolean = assignmentAvailable
        protected set

    @ManyToOne
    @JoinColumn(name = "prerequisite_subject_id")
    var prerequisiteSubject: Subject? = prerequisiteSubject
        protected set
}