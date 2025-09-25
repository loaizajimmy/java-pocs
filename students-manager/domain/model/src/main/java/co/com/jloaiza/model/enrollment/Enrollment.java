package co.com.jloaiza.model.enrollment;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Enrollment {
    private Integer id;
    private Integer studentId;
    private Integer subjectId;
    private String groupIdentifier;
    private LocalDateTime enrolledAt;
}
