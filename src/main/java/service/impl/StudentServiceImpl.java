package service.impl;


import entity.Course;
import entity.Lesson;
import entity.ReportCard;
import entity.Student;
import repository.ReportCardRepository;
import repository.StudentRepository;
import service.ReportCardService;
import service.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentServiceImpl extends UserServiceImpl<Student, StudentRepository> implements StudentService {

    private final ReportCardRepository reportCardRepository;


    public StudentServiceImpl(StudentRepository repository, ReportCardRepository reportCardRepository) {
        super(repository);
        this.reportCardRepository = reportCardRepository;
    }

    public List<Course> chooseCourses(Student student, List<Course> availableCourses) {
        List<Course> chosenCourses = new ArrayList<>();
        double previousGPA = reportCardRepository.getAvg(student);
        int maxUnits = (previousGPA > 18) ? 24 : 20;
        Set<Lesson> passedLessons = getPassedLessons(student);
        for (Course course : availableCourses) {
            if (!passedLessons.contains(course.getLesson())) {
                if (!isSimilarCourseChosen(student, course)) {
                    if (chosenCourses.size() < maxUnits) {
                        chosenCourses.add(course);
                    } else {
                        // Handle exceeding maximum units
                        // (e.g., throw an exception or log a message)
                    }
                }
            }
        }
        return chosenCourses;
    }

    private Set<Lesson> getPassedLessons(Student student) {
        Set<Lesson> passedLessons = new HashSet<>();

        for (ReportCard studentCourse : student.getReportCards()) {
            if (studentCourse.getCourse().getIsPass()) {
                passedLessons.add(studentCourse.getCourse().getLesson());
            }
        }

        return passedLessons;
    }

    private boolean isSimilarCourseChosen(Student student, Course course) {
        for (ReportCard studentCourse : student.getReportCards()) {
            if (studentCourse.getCourse().getLesson().equals(course.getLesson())) {
                return true; // Similar course already chosen
            }
        }
        return false; // No similar course chosen
    }
}