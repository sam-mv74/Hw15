package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student extends User{

    @Column(name = "student_number")
    private String studentNumber;

    @OneToMany(mappedBy = "student")
    private Set<ReportCard> reportCards;

}