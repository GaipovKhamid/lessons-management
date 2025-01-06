package com.khamid.spring_exercises.repository;

import com.khamid.spring_exercises.entity.StudentEntity;
import com.khamid.spring_exercises.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    List<StudentEntity> getByName(String name);

    List<StudentEntity> getBySurname(String surname);

    List<StudentEntity> getByGender(Gender gender);

    List<StudentEntity> getByAge(Integer age);

    List<StudentEntity> getByLevel(Integer level);

    List<StudentEntity> findByCreatedDate_Date(LocalDate givenDate);
}
