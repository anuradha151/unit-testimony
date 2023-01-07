package com.anuradha.unittestone.controller;

import com.anuradha.unittestone.dto.StudentDto;
import com.anuradha.unittestone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }
}
