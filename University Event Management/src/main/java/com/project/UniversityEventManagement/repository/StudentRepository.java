package com.project.UniversityEventManagement.repository;

import com.project.UniversityEventManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
