package com.khamid.spring_exercises.service;

import com.khamid.spring_exercises.dto.StudentDTO;
import com.khamid.spring_exercises.entity.StudentEntity;
import com.khamid.spring_exercises.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public StudentDTO create(StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setLevel(studentDTO.getLevel());
        studentEntity.setAge(studentDTO.getAge());
        studentEntity.setGender(studentDTO.getGender());
        studentEntity.setCreatedDate(LocalDateTime.now());

        repository.save(studentEntity); //

        studentDTO.setId(studentEntity.getId());
        studentDTO.setCreatedDate(LocalDateTime.now());
        return studentDTO;
    }

    public List<StudentDTO> viewAll() {
        Iterable<StudentEntity> interator = repository.findAll(); //iterable= for each da aylantirish uchun royihatni retunr qiladi
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : interator) {
            list.add(toDto(entity));
        }
        return list;
    }

    //by id
    public StudentDTO getById(Integer id) {
        Optional<StudentEntity> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        return toDto(entity);
    }

    //update
    public StudentDTO update(Integer id, StudentDTO dto) {
        Optional<StudentEntity> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        toDto(entity);
        repository.save(entity);

        return dto;
    }

    //delete by id
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public StudentDTO toDto(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setLevel(entity.getLevel());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setCreatedDate(LocalDateTime.now());
        return dto;
    }
}
