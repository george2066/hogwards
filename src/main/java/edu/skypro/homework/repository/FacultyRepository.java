package edu.skypro.homework.repository;

import edu.skypro.homework.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(String color, String name);

    Optional<Faculty> findByNameIgnoreCase(String facultyName);
}
