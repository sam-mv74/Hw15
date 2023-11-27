package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public class User extends BaseEntity<Integer> {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

}