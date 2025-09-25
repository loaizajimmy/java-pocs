package co.com.jloaiza.jpa.entities.subject;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subject")
public class SubjectData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(unique = true)
    private String code;

    @Column
    private String name;
}
