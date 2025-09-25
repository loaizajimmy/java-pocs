package co.com.jloaiza.model.subject.gateways;

import co.com.jloaiza.model.subject.Subject;

import java.util.List;

public interface ISubjectRepository {
    Subject save(Subject subject);

    Subject findByCode(String code);

    List<Subject> findAll();
}
