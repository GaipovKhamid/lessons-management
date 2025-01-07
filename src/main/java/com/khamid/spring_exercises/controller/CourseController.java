package com.khamid.spring_exercises.controller;

import com.khamid.spring_exercises.dto.CourseDTO;
import com.khamid.spring_exercises.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.createCourse(courseDTO));
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<CourseDTO>> viewAllCourses() {
        return ResponseEntity.ok(courseService.viewAllCourse());
    }

    @GetMapping("/viewById/{id}")
    public ResponseEntity<CourseDTO> viewCourseById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable int id) {
        return ResponseEntity.ok(courseService.update(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CourseDTO> deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/kill")
    public ResponseEntity<CourseDTO> killCourse() {
        courseService.kill();
        return ResponseEntity.ok().build();
    }
}
