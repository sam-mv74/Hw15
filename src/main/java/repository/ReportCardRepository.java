package repository;

import base.repository.BaseEntityRepository;
import entity.ReportCard;
import entity.Student;

public interface ReportCardRepository extends BaseEntityRepository<ReportCard,Integer> {

    public Double getAvg(Student student);
}
