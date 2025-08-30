package com.varunu28.springjdbcdemo.model;

import org.springframework.data.annotation.Id;

public class StudentCourse {

    private final Integer studentId;
    private final Integer courseId;
    @Id
    private Integer id;

    public StudentCourse(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }
}
