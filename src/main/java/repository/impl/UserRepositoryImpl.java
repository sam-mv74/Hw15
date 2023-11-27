package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.User;
import repository.UserRepository;

import javax.persistence.EntityManager;

public abstract class UserRepositoryImpl<T extends User> extends BaseEntityRepositoryImpl<T, Integer> implements UserRepository<T> {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

}