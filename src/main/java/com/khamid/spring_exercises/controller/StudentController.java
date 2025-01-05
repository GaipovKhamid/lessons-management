package com.khamid.spring_exercises.controller;


import com.khamid.spring_exercises.dto.StudentDTO;
import com.khamid.spring_exercises.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("")
    private ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("")
    private ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(service.viewAll());
    }
}
