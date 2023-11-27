package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher extends Employee{

    @Column(name = "teacher_number")
    private String teacherNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "teacher_type")
    private TeacherType teacherType;

}