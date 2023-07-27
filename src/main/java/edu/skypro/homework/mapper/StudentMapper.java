package edu.skypro.homework.mapper;

import edu.skypro.homework.dto.StudentDtoIn;
import edu.skypro.homework.dto.StudentDtoOut;
import edu.skypro.homework.exception.FacultyNotFoundException;
import edu.skypro.homework.model.Student;
import edu.skypro.homework.repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StudentMapper {
    private final FacultyMapper facultyMapper;
    private final FacultyRepository facultyRepository;

    public StudentDtoOut toDto(Student student) {
        StudentDtoOut studentDtoOut = new StudentDtoOut();
        studentDtoOut.setId(student.getId());
        studentDtoOut.setName(student.getName());
        studentDtoOut.setAge(student.getAge());
        Optional.ofNullable(student.getFaculty())
                .ifPresent(faculty -> studentDtoOut.setFaculty(facultyMapper.toDto(faculty)));
        return studentDtoOut;
    }

    public Student toEntity(StudentDtoIn studentDtoIn) {
        Student student = new Student();
        student.setName(studentDtoIn.getName());
        student.setAge(studentDtoIn.getAge());
        student.setFaculty(
                facultyRepository.findById(
                        studentDtoIn.getFacultyId()
                ).orElseThrow(() -> new FacultyNotFoundException(studentDtoIn.getFacultyId()))
        );
        return student;
    }
}
