package com.varunu28.springjdbcdemo.repository;

import com.varunu28.springjdbcdemo.model.StudentCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Integer> {
}
