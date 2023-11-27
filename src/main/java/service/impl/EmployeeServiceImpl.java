package service.impl;

import entity.Employee;

import repository.EmployeeRepository;
import service.EmployeeService;

@SuppressWarnings("unused")
public class EmployeeServiceImpl extends UserServiceImpl<Employee, EmployeeRepository> implements EmployeeService {


    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}