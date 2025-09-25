package co.com.jloaiza.model.enrollment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Enrollment {
    private int id;
    private int studentId;
    private int subjectId;
    private String groupIdentifier;
    private LocalDateTime enrolledAt;
}
