package site.rookies.guide.repositories

import org.springframework.data.jpa.repository.JpaRepository
import site.rookies.guide.entity.Subject

interface SubjectRepository : JpaRepository<Subject, Int>{
}