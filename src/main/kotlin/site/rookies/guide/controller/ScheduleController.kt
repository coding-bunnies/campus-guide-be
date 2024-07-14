package site.rookies.guide.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import site.rookies.guide.dto.ScheduleRequest
import site.rookies.guide.dto.SchedulesResponse
import site.rookies.guide.services.ScheduleService

@RestController
@RequestMapping("/api/schedules")
class ScheduleController(
    private val scheduleService: ScheduleService
) {
    @GetMapping("")
    fun getSchedules(
        scheduleRequest: ScheduleRequest
    ): SchedulesResponse {
        val list = scheduleService.list(year = scheduleRequest.year, month = scheduleRequest.month)

        return SchedulesResponse(list = list)
    }
}