package com.varunu28.springjdbcdemo.repository;

import com.varunu28.springjdbcdemo.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
