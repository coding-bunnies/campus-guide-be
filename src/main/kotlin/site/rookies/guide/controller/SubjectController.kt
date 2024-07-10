package site.rookies.guide.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import site.rookies.guide.dto.SubjectRequest
import site.rookies.guide.dto.SubjectResponse
import site.rookies.guide.services.SubjectService

@RestController
@RequestMapping("/api/subjects")
class SubjectController(private val subjectService: SubjectService) {
    @GetMapping("/")
    fun getSubjects(request: SubjectRequest): SubjectResponse {
        return SubjectResponse(subjectService.list(request))
    }
}