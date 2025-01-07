package com.khamid.spring_exercises.service;

import com.khamid.spring_exercises.dto.CourseDTO;
import com.khamid.spring_exercises.dto.StudentDTO;
import com.khamid.spring_exercises.entity.CourseEntity;
import com.khamid.spring_exercises.entity.StudentEntity;
import com.khamid.spring_exercises.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> viewAllCourse() {
        Iterable<CourseEntity> interator = courseRepository.findAll(); //iterable= for each da aylantirish uchun royihatni retunr qiladi
        List<CourseDTO> list = new LinkedList<>();
        for (CourseEntity entity : interator) {
            list.add(toDto(entity));
        }
        return list;
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setName(courseDTO.getName());
        courseEntity.setPrice(courseDTO.getPrice());
        courseEntity.setDuration(courseDTO.getDuration());
        courseEntity.setCreatedDate(LocalDateTime.now());

        courseRepository.save(courseEntity); //

        courseDTO.setId(courseEntity.getId());
        courseDTO.setCreatedDate(LocalDateTime.now());
        return courseDTO;
    }

    public CourseDTO getById(int id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        CourseEntity entity = optional.get();
        return toDto(entity);
    }

    public CourseDTO update(int id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        CourseEntity courseEntity = optional.get();
        toDto(courseEntity);

        courseRepository.save(courseEntity);
        return toDto(courseEntity);
    }

    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    public void kill() {
        courseRepository.deleteAll();
    }

    public List<CourseDTO> getByName(String name) {
        List<CourseEntity> entityList = courseRepository.getByName(name);
        List<CourseDTO> list = new LinkedList<>();
        for (CourseEntity entity : entityList) {
            list.add(toDto(entity));
        }
        return list;
    }

    public List<CourseDTO> getByPrice(Double price) {
        List<CourseEntity> entityList =  courseRepository.getByPrice(price);
        List<CourseDTO> list = new LinkedList<>();
        for (CourseEntity entity : entityList) {
            list.add(toDto(entity));
        }
        return list;
    }

    public List<CourseDTO> getByDuration(Integer duration) {
        List<CourseEntity> entityList = courseRepository.getByDuration(duration);
        List<CourseDTO> list = new LinkedList<>();
        for (CourseEntity entity : entityList) {
            list.add(toDto(entity));
        }
        return list;
    }

    public CourseDTO toDto(CourseEntity entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDuration(entity.getDuration());
        dto.setPrice(entity.getPrice());
        dto.setCreatedDate(LocalDateTime.now());

        return dto;
    }
}
