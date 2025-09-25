package co.com.jloaiza.jpa.entities.enrollment;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "enrollment", uniqueConstraints = @UniqueConstraint(columnNames = {"studentId", "subjectId"}))
public class EnrollmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer studentId;
    private Integer subjectId;
    private String groupIdentifier;
    private LocalDateTime enrolledAt;
}
