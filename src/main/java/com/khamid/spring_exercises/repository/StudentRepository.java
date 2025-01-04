package com.khamid.spring_exercises.repository;

import com.khamid.spring_exercises.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}
