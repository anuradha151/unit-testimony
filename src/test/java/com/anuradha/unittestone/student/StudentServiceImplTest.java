package com.anuradha.unittestone.student;

import com.anuradha.unittestone.entity.Student;
import com.anuradha.unittestone.enums.Gender;
import com.anuradha.unittestone.repo.StudentRepository;
import com.anuradha.unittestone.service.StudentService;
import com.anuradha.unittestone.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private ModelMapper modelMapper;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl(studentRepository, modelMapper);
    }

    @Test
    void findAll() {
        studentService.findAll();
        verify(studentRepository).findAll();

    }

    @Test
    void save() {
        // given
        Student student = new Student("Mahinda Rajapaksa", "hora.gediya@gmail.com", Gender.MALE);

        // when
        studentService.save(student);

        // then
        ArgumentCaptor<Student> argumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(argumentCaptor.capture());

        Student value = argumentCaptor.getValue();

        assertThat(value).isEqualTo(student);


    }

    @Test
    @Disabled
    void remove() {
    }
}