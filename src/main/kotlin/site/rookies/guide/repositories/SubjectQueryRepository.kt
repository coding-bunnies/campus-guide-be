package site.rookies.guide.repositories

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import site.rookies.guide.entity.QSubject.subject
import site.rookies.guide.entity.Subject

@Repository
class SubjectQueryRepository(
    private val queryFactory: JPAQueryFactory
) {
    fun findAll(grade: Int?, semester: Int?, subjectTitle: String?): List<Subject> {
        val query = queryFactory.from(subject)

        if (subjectTitle != null) {
            query.where(subject.title.eq(subjectTitle))
        }
        if (grade != null) {
            query.where(subject.grade.eq(grade))
        }
        if (semester != null) {
            query.where(subject.semester.eq(semester))
        }
        return query.select(subject).fetch()
    }
}