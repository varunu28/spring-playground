package com.varunu28.springjdbcdemo.repository;

import com.varunu28.springjdbcdemo.model.StudentCourse;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Integer> {

    @Query("SELECT sc.student_id FROM student_course sc WHERE sc.course_id = :courseId")
    List<Integer> findStudentsEnrolledInCourse(Integer courseId);
}
