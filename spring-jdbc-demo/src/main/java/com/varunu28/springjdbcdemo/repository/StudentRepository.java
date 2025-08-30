package com.varunu28.springjdbcdemo.repository;

import com.varunu28.springjdbcdemo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
