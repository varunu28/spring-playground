package com.varunu28.springjdbcdemo.controller;

import com.varunu28.springjdbcdemo.dto.CourseEnrollmentRequest;
import com.varunu28.springjdbcdemo.exception.EnrollmentDataIntegrityException;
import com.varunu28.springjdbcdemo.model.StudentCourse;
import com.varunu28.springjdbcdemo.repository.StudentCourseRepository;
import java.util.List;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    private final StudentCourseRepository studentCourseRepository;

    public EnrollmentController(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @PostMapping
    public ResponseEntity<Void> enrollInCourse(@RequestBody @Validated CourseEnrollmentRequest request)
        throws EnrollmentDataIntegrityException {
        StudentCourse studentCourse = new StudentCourse(request.studentId(), request.courseId());
        try {
            studentCourseRepository.save(studentCourse);
        } catch (DbActionExecutionException e) {
            throw new EnrollmentDataIntegrityException(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> unenrollFromCourse(@RequestBody @Validated CourseEnrollmentRequest request) {
        StudentCourse studentCourse = new StudentCourse(request.studentId(), request.courseId());
        studentCourseRepository.delete(studentCourse);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Iterable<Integer>> getEnrolledStudentsInCourse(
        @PathVariable("courseId") Integer courseId) {
        List<Integer> studentsEnrolledInCourse = studentCourseRepository.findStudentsEnrolledInCourse(courseId);
        return ResponseEntity.ok(studentsEnrolledInCourse);
    }
}
