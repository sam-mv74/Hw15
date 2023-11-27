package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.ReportCard;
import entity.Student;
import repository.ReportCardRepository;
import service.ReportCardService;

public class ReportCardServiceImpl extends BaseEntityServiceImpl<ReportCard,Integer,ReportCardRepository> implements ReportCardService {

    public ReportCardServiceImpl(ReportCardRepository repository) {
        super(repository);
    }

    @Override
    public Double getAvg(Student student) {
        return repository.getAvg(student);
    }
}