package com.khamid.spring_exercises.controller;


import com.khamid.spring_exercises.dto.StudentDTO;
import com.khamid.spring_exercises.enums.Gender;
import com.khamid.spring_exercises.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;
    private LocalDate date;

    @PostMapping("/create")
    private ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/viewAll")
    private ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(service.viewAll());
    }

    @GetMapping("/viewById/{id}")
    private ResponseEntity<StudentDTO> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestParam StudentDTO dto) {
        StudentDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<StudentDTO> delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getByName/{name}")
    private ResponseEntity<List<StudentDTO>> getByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/getBySurname/{surname}")
    private ResponseEntity<List<StudentDTO>> getBySurname(@PathVariable("surname") String name) {
        return ResponseEntity.ok(service.getBySurname(name));
    }

    @GetMapping("/getByAge/{age}")
    private ResponseEntity<List<StudentDTO>> getByAge(@PathVariable("age") Integer age) {
        return ResponseEntity.ok(service.getByAge(age));
    }

    @GetMapping("/getByLevel/{level}")
    private ResponseEntity<List<StudentDTO>> getBylevel(@PathVariable("level") Integer level) {
        return ResponseEntity.ok(service.getByLevel(level));
    }

    @GetMapping("/getByGender/{gender}")
    private ResponseEntity<List<StudentDTO>> getBygender(@PathVariable("gender") Gender gender) {
        return ResponseEntity.ok(service.getByGender(gender));
    }

    @GetMapping("/givenDate/{date}" )
    private ResponseEntity<List<StudentDTO>> getByDate(@PathVariable("date") LocalDate date) {
        return ResponseEntity.ok(service.getByDate(date));
    }
}
