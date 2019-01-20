package by.bsac.server.api.servise.dao.interfaces;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Subject;

import java.util.List;

public interface SubjectDAO {
    void add(Subject subject);

    void addAll(List<Subject> listSubject);

    void update(Subject subject);

    void updateAll(List<Subject> listSubject);

    Subject getById(Short idSubject);

    List<Subject> getAll();

    void delete(Subject subject);

    List<Subject> getSubjectListByChair(Chair chair);

    List<Subject> getSubjectListByChairAndEduLevel(Chair chair, byte eduLevel);

    List<Subject> getAllWithSimilarName(String nameSubject);
}
