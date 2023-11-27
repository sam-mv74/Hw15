package service;

import base.service.BaseEntityService;
import entity.ReportCard;
import entity.Student;

public interface ReportCardService extends BaseEntityService<ReportCard, Integer> {

    Double getAvg(Student student);
}