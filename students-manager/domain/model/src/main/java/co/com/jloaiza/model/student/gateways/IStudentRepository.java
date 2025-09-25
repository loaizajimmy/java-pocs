package co.com.jloaiza.model.student.gateways;

import co.com.jloaiza.model.student.Student;

import java.util.List;

public interface IStudentRepository {

    Student save(Student student);

    Student findById(Integer id);

    Student findByDocument(String document);

    List<Student> findAll();
}
