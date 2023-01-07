package com.anuradha.unittestone.dto;

import com.anuradha.unittestone.enums.Gender;
import lombok.Data;

@Data
public class StudentDto {
    private int id;
    private String name;
    private String email;
    private Gender gender;
}
