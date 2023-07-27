package edu.skypro.homework.service;

import edu.skypro.homework.dto.FacultyDtoIn;
import edu.skypro.homework.dto.FacultyDtoOut;
import edu.skypro.homework.dto.StudentDtoOut;
import edu.skypro.homework.exception.FacultyNameNotFoundException;
import edu.skypro.homework.exception.FacultyNotFoundException;
import edu.skypro.homework.mapper.FacultyMapper;
import edu.skypro.homework.mapper.StudentMapper;
import edu.skypro.homework.model.Faculty;
import edu.skypro.homework.repository.FacultyRepository;
import edu.skypro.homework.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public FacultyDtoOut create(FacultyDtoIn facultyDtoIn) {
        return facultyMapper.toDto(
                facultyRepository.save(
                        facultyMapper.toEntity(facultyDtoIn)
                )
        );
    }

    public FacultyDtoOut get(long id) {
        return facultyMapper.toDto(
                facultyRepository.findById(id)
                        .orElseThrow(() -> new FacultyNotFoundException(id)));
    }

    public FacultyDtoOut update(long id, FacultyDtoIn facultyDtoIn) {
        Faculty updatedFaculty = facultyRepository.findById(id).
                map(faculty -> {
                    faculty.setName(facultyDtoIn.getName());
                    faculty.setColor(facultyDtoIn.getColor());
                    return faculty;
                })
                .orElseThrow(() -> new FacultyNotFoundException(id));
        facultyRepository.save(updatedFaculty);
        return facultyMapper.toDto(updatedFaculty);
    }

    public FacultyDtoOut delete(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
        facultyRepository.deleteById(id);
        return facultyMapper.toDto(faculty);
    }

    public Collection<FacultyDtoOut> findByColorOrName(String colorOrName) {
        return facultyRepository.findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(
                        colorOrName, colorOrName
                ).stream()
                .map(facultyMapper::toDto)
                .toList();
    }

    public Collection<StudentDtoOut> findStudentsByFaculty(String facultyName) {
        return facultyRepository.findByNameIgnoreCase(facultyName)
                .map(Faculty::getId)
                .map(studentRepository::findAllByFaculty_id)
                .orElseThrow(() -> new FacultyNameNotFoundException(facultyName)).stream()
                .map(studentMapper::toDto)
                .toList();
    }
}
