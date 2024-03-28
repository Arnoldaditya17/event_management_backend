package com.project.UniversityEventManagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;




@Entity
@Table(name = "users")
@Setter
@Data

public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phone;



}
