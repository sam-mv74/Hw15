package service.impl;

import entity.Teacher;
import repository.TeacherRepository;

import service.TeacherService;

@SuppressWarnings("unused")
public class TeacherServiceImpl extends UserServiceImpl<Teacher, TeacherRepository> implements TeacherService {


    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }
}