package com.varunu28.springjdbcdemo.controller;

import com.varunu28.springjdbcdemo.exception.StudentNotFoundException;
import com.varunu28.springjdbcdemo.model.Student;
import com.varunu28.springjdbcdemo.repository.StudentRepository;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public ResponseEntity<Integer> createStudent(@RequestParam String name) {
        Student student = new Student(null, name);
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(String.format("student with id %d not found", id));
        }
        return ResponseEntity.ok(student.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
