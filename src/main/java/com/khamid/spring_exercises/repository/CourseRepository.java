package com.khamid.spring_exercises.repository;

import com.khamid.spring_exercises.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
     List<CourseEntity> getByName(String name);

    List<CourseEntity> getByPrice(Double price);

    List<CourseEntity> getByDuration(Integer duration);
}
