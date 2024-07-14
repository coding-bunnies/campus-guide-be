package site.rookies.guide.repositories

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import site.rookies.guide.entity.QSchedule.schedule
import site.rookies.guide.entity.Schedule
import java.time.LocalDateTime

@Repository
class ScheduleQueryRepository(
    private val queryFactory: JPAQueryFactory
) {
    fun findAll(startAt: LocalDateTime, endAt: LocalDateTime): List<Schedule> {
        return queryFactory.from(schedule)
            .where(schedule.startAt.goe(startAt), schedule.endAt.loe(endAt))
            .select(schedule)
            .fetch()
    }
}