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
    private ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestParam StudentDTO dto){
        StudentDTO result = service.update(id,dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<StudentDTO> delete(@PathVariable("id") Integer id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
