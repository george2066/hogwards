package edu.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDtoIn {
    private String name;
    private int age;
    private long facultyId;
}
