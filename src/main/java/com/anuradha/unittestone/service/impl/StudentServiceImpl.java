package com.anuradha.unittestone.service.impl;

import com.anuradha.unittestone.dto.StudentDto;
import com.anuradha.unittestone.entity.Student;
import com.anuradha.unittestone.repo.StudentRepository;
import com.anuradha.unittestone.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentRepository.save(modelMapper.map(studentDto, Student.class));
        return modelMapper.map(student,StudentDto.class);
    }
}
