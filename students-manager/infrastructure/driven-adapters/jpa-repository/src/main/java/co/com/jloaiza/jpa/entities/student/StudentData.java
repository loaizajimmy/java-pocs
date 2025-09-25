package co.com.jloaiza.jpa.entities.student;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(unique = true)
    private String document;

    @Column
    private String name;

    @Column
    private String lastName;
}
