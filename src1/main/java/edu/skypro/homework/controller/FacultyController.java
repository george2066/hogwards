package edu.skypro.homework.controller;

import edu.skypro.homework.dto.FacultyDtoIn;
import edu.skypro.homework.dto.FacultyDtoOut;
import edu.skypro.homework.dto.StudentDtoOut;
import edu.skypro.homework.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService service;

    @PostMapping
    public FacultyDtoOut create(@RequestBody FacultyDtoIn facultyDtoIn) {
        return service.create(facultyDtoIn);
    }

    @GetMapping("{id}")
    public FacultyDtoOut get(@PathVariable long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public FacultyDtoOut update(@PathVariable long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return service.update(id, facultyDtoIn);
    }

    @DeleteMapping("{id}")
    public FacultyDtoOut delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/filter")
    public Collection<FacultyDtoOut> filter(@RequestParam String colorOrName) {
        return service.findByColorOrName(colorOrName);
    }

    @GetMapping("/{facultyName}/students")
    public Collection<StudentDtoOut> findAllStudentsOnFaculty(@PathVariable String facultyName) {
        return service.findStudentsByFaculty(facultyName);
    }
}
