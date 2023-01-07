package com.anuradha.unittestone.student;

import com.anuradha.unittestone.entity.Student;
import com.anuradha.unittestone.enums.Gender;
import com.anuradha.unittestone.repo.StudentRepository;
import com.anuradha.unittestone.service.StudentService;
import com.anuradha.unittestone.service.impl.StudentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.anyString;
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

        BDDMockito.given(studentRepository.selectExistsEmail(anyString())).willReturn(true);
        // when
        // then
        Assertions.assertThatThrownBy(()-> studentService.save(student))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("Existing email address. Please use another");





    }

    @Test
    @Disabled
    void remove() {
    }
}