package com.anuradha.unittestone.service;

import com.anuradha.unittestone.dto.StudentDto;
import com.anuradha.unittestone.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<StudentDto> findAll();
    void remove(int id);


}
