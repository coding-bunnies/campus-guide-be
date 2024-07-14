package site.rookies.guide.dto

import java.time.LocalDateTime

class SchedulesDto(
    val id: Int,
    val startAt: LocalDateTime,
    val endAt: LocalDateTime,
    val description: String
)