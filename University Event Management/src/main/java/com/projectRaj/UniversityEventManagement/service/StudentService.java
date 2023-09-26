package com.projectRaj.UniversityEventManagement.service;

import com.projectRaj.UniversityEventManagement.model.Department;
import com.projectRaj.UniversityEventManagement.model.Student;
import com.projectRaj.UniversityEventManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student added successfully with ID: " +student.getStudentId() ;
    }

    public String addStudents(List<Student> students) {
        studentRepository.saveAll(students);
        return students.size()+" Student added successfully";
    }

    public String updateStudentDepartment(Long studentId, Department newDepartment) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setDepartment(newDepartment);
            studentRepository.save(student);
            return "Department updated for student with ID: " + studentId;
        }
        return "Record not found for student with ID: " + studentId;
    }

    public String deleteStudent(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            studentRepository.deleteById(studentId);
            return "Student with ID: " + studentId + " deleted successfully";
        }

        return "Student with ID: " + studentId + " not found";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Object getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            return studentRepository.findById(studentId);
        }

        return "Student with ID: " + studentId + " not found";
    }

}