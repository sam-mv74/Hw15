package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class ReportCard extends BaseEntity<Integer> {

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    private Double mark;

    @Column(columnDefinition = "Boolean default false")
    private Boolean isPass;

}