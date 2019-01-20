package by.bsac.server.api.servise.dao.interfaces;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Lecturer;

import java.util.List;

public interface LecturerDAO {
     void add(Lecturer lecturer);

    void addAll(List<Lecturer> listLecturer);

    void update(Lecturer lecturer);

    void updateAll(List<Lecturer> listLecturer);

    Lecturer getById(Short idLecturer);

    List<Lecturer> getAll();

    void delete(Lecturer lecturer);

    List<Lecturer> getLecturerListByChair(Chair chair);

    List<Lecturer> getAllWithSimilarName(String nameLecturer);
}
