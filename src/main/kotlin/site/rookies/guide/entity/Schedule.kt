package site.rookies.guide.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "schedules")
class Schedule(
    startAt: LocalDateTime,
    endAt: LocalDateTime,
    description: String
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Int = 0

    @Column(name = "start_at")
    var startAt: LocalDateTime = startAt
        protected set

    @Column(name = "end_at")
    var endAt: LocalDateTime = endAt
        protected set

    @Column(name = "description", nullable = false)
    var description: String = description
        protected set
}