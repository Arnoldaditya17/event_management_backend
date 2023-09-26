package com.projectRaj.UniversityEventManagement.controller;

import com.projectRaj.UniversityEventManagement.model.Department;
import com.projectRaj.UniversityEventManagement.model.Student;
import com.projectRaj.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("api/student")
    public String addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("api/students")
    public String addStudents(@Valid @RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }

    @PutMapping("api/student/id/{studentId}/updateDepartment")
    public String updateStudentDepartment(@PathVariable Long studentId, @RequestParam @NotNull Department newDepartment) {
        return studentService.updateStudentDepartment(studentId, newDepartment);
    }

    @DeleteMapping("api/student/id/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("api/students/")
    public List<Student> getAllStudents() {
         return studentService.getAllStudents();
    }

    @GetMapping("api/id/{studentId}")
    public Object getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

}
