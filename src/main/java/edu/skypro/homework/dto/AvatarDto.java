package edu.skypro.homework.dto;

import edu.skypro.homework.model.Student;
import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class AvatarDto {
    private long id;
    private String avatarUrl;
    private long fileSize;
    private String mediaType;
    private long studentId;
}
