package edu.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "filePath")
@ToString(exclude = "student")
@Builder
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String filePath;

    @Column(nullable = false)
    private long fileSize;

    private String mediaType;

    @Lob
    private byte[] data;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;
}
