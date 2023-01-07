package com.anuradha.unittestone.student;

import com.anuradha.unittestone.entity.Student;
import com.anuradha.unittestone.enums.Gender;
import com.anuradha.unittestone.repo.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.*;
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void selectExistsEmail() {
        //given
        String email = "hora@gmail.com";
        Student student = new Student("Mahinda Rajapaksa", email, Gender.MALE);
        studentRepository.save(student);
        //when
        Boolean expected = studentRepository.selectExistsEmail(email);
        //then
        assertThat(expected).isTrue();
    }

    @Test
    void selectNotExistsEmail() {
        //given
        String email = "hora@gmail.com";
        //when
        Boolean expected = studentRepository.selectExistsEmail(email);
        //then
        assertThat(expected).isFalse();

    }
}