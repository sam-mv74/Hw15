package service;

import entity.Course;
import entity.Student;

import java.util.List;

public interface StudentService extends UserService<Student> {

    List<Course> chooseCourses(Student student, List<Course> availableCourses);

}