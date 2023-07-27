package edu.skypro.homework.repository;

import edu.skypro.homework.model.Avatar;
import edu.skypro.homework.model.Student;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudent_id(Long studentId);
    @Query("""
            select student.id
            from Avatar
            where id = :avatarId
            """)
    Long studentId(@Param("avatarId") long id);
}
