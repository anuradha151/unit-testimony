package com.anuradha.unittestone.service.impl;

import com.anuradha.unittestone.dto.StudentDto;
import com.anuradha.unittestone.entity.Student;
import com.anuradha.unittestone.repo.StudentRepository;
import com.anuradha.unittestone.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Student save(Student student) {
        Boolean aBoolean = studentRepository.selectExistsEmail(student.getEmail());
        if (aBoolean) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing email address. Please use another");
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void remove(int id) {
        studentRepository.deleteById(id);
    }

    private StudentDto convertToDto(Student student) {
       return modelMapper.map(student, StudentDto.class);
    }
}
