package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.ReportCard;
import entity.Student;
import entity.Term;
import repository.ReportCardRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReportCardRepositoryImpl extends BaseEntityRepositoryImpl<ReportCard, Integer> implements ReportCardRepository {
    public ReportCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ReportCard> getEntityClass() {
        return ReportCard.class;
    }

    @Override
    public Double getAvg(Student student) {

        Term term = currentTerm();
        String hql = "SELECT avg(mark) FROM ReportCard WHERE student = :student AND course.term.midTerm = :midTerm AND course.term.year = :year";
        TypedQuery<Double> query = entityManager.createQuery(hql, Double.class);
        query.setParameter("student", student);
        query.setParameter("midTerm", term.getMidTerm());
        query.setParameter("year", term.getYear());
        return query.getSingleResult();

    }

    public Term currentTerm() {

        String hql = "SELECT r FROM ReportCard r ORDER BY r.id desc";
        TypedQuery<ReportCard> reportCardTypedQuery = entityManager.createQuery(hql, ReportCard.class);
        reportCardTypedQuery.setMaxResults(1);
        ReportCard reportCard = reportCardTypedQuery.getSingleResult();
        return reportCard.getCourse().getTerm();

//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ReportCard> cq = cb.createQuery(ReportCard.class);
//        Root<ReportCard> root = cq.from(ReportCard.class);
//        cq.select(root);
//        cq.orderBy(cb.desc(root.get("id")));
//        TypedQuery<ReportCard> query = entityManager.createQuery(cq).setMaxResults(1);
//        ReportCard reportCard = query.getSingleResult();
//        return reportCard.getCourse().getTerm();

    }
}