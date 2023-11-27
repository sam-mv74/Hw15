package entity;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
@Setter
@Getter
@Table(name = "report_card")
@Entity
public class ReportCard extends BaseEntity<Integer> {

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private Double mark;

}