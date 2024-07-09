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
) {
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

    @Column(name = "outline", nullable = false)
    var outline: String = outline
        protected set

    @Column(name = "image_url", nullable = false)
    var imageUrl: String = imageUrl
        protected set
}