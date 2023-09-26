package com.projectRaj.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private Long studentId;

    @NotEmpty
    @Pattern(regexp="^[A-Z][a-zA-Z]*$")
    private String firstName;

    @NotEmpty
    @Pattern(regexp="^[A-Z][a-zA-Z]*$")
    private String lastName;


    @Min(18)
    @Max(30)
    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;
}
