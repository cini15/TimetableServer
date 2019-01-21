package by.bsac.server.api.service.dao.interfaces;

import by.bsac.server.api.date.entity.Faculty;

import java.util.List;

public interface FacultyDAO {
    void add(Faculty faculty);

    void addAll(List<Faculty> listFaculty);

    void update(Faculty faculty);

    void updateAll(List<Faculty> listFaculty);

    Faculty getById(Byte idFaculty);

    List<Faculty> getAll();

    void delete(Faculty faculty);
}
