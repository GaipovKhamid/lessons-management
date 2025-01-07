package com.khamid.spring_exercises.repository;

import com.khamid.spring_exercises.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
}
