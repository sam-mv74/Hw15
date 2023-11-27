package repository.impl;

import entity.Teacher;
import repository.TeacherRepository;

import javax.persistence.EntityManager;

@SuppressWarnings("unused")
public class TeacherRepositoryImpl extends UserRepositoryImpl<Teacher> implements TeacherRepository {

    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }
}