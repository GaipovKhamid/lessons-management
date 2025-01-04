package com.khamid.spring_exercises.entity;

import com.khamid.spring_exercises.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer level;

    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private LocalDateTime createdDate;
}
