package co.com.jloaiza.usecase.subjects;

import co.com.jloaiza.model.subject.Subject;
import co.com.jloaiza.model.subject.gateways.ISubjectRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static co.com.jloaiza.model.error.BusinessException.Type.RESOURCE_NOT_FOUND;
import static co.com.jloaiza.model.error.BusinessException.Type.SUBJECT_ALREADY_EXISTS;

@RequiredArgsConstructor
public class SubjectsUseCase {

    private final ISubjectRepository subjectRepository;

    public List<Subject> findAll() {
        return this.subjectRepository.findAll();
    }

    public Subject save(Subject subject) {
        var existingSubject = this.subjectRepository.findByCode(subject.getCode());
        if (existingSubject != null) {
            throw SUBJECT_ALREADY_EXISTS.build(String.format("Code: %s", subject.getCode()));
        }
        return this.subjectRepository.save(subject);
    }

    public Subject findByCode(String code) {
        var subject = this.subjectRepository.findByCode(code);
        if (subject == null) {
            throw RESOURCE_NOT_FOUND.build(String.format("Subject with code %s not found", code));
        }
        return subject;
    }
}
