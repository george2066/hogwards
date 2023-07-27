package edu.skypro.homework.mapper;

import edu.skypro.homework.dto.FacultyDtoIn;
import edu.skypro.homework.dto.FacultyDtoOut;
import edu.skypro.homework.model.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {

    public FacultyDtoOut toDto(Faculty faculty) {
        FacultyDtoOut facultyDtoOut = new FacultyDtoOut();
        facultyDtoOut.setId(faculty.getId());
        facultyDtoOut.setName(faculty.getName());
        facultyDtoOut.setColor(faculty.getColor());
        return facultyDtoOut;
    }

    public Faculty toEntity(FacultyDtoIn facultyDtoIn) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDtoIn.getName());
        faculty.setColor(facultyDtoIn.getColor());
        return faculty;
    }
}
