package site.rookies.guide.repositories

import org.springframework.data.jpa.repository.JpaRepository
import site.rookies.guide.entity.Schedule

interface ScheduleRepository: JpaRepository<Schedule, Int> {
}