package com.varunu28.springjdbcdemo.controller;

import com.varunu28.springjdbcdemo.dto.CourseCreationRequest;
import com.varunu28.springjdbcdemo.exception.CourseNotFoundException;
import com.varunu28.springjdbcdemo.model.Course;
import com.varunu28.springjdbcdemo.repository.CourseRepository;
import java.util.Optional;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody CourseCreationRequest courseCreationRequest)
        throws BadRequestException {
        courseCreationRequest.validate();
        Course course = new Course(null, courseCreationRequest.name(), courseCreationRequest.description());
        Course save = courseRepository.save(course);
        return ResponseEntity.ok(save.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> get(@PathVariable("id") Integer id) throws CourseNotFoundException {
        Optional<Course> byId = courseRepository.findById(id);
        if (byId.isEmpty()) {
            throw new CourseNotFoundException(String.format("course with id %d not found", id));
        }
        return ResponseEntity.ok(byId.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        courseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
