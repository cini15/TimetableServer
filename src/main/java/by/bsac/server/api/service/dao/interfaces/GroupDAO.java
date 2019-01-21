package by.bsac.server.api.service.dao.interfaces;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Flow;
import by.bsac.server.api.date.entity.Group;

import java.util.List;

public interface GroupDAO {
    void add(Group group);

    void addAll(List<Group> listGroup);

    void update(Group group);

    void updateAll(List<Group> listGroup);

    Group getById(Short idGroup);

    List<Group> getAll();

    void delete(Group group);

    List getGroupListByFaculty(Faculty faculty);

    List<Group> getGroupListByFacultyAndEduLevel(Faculty faculty, byte eduLevel);

    List<Group> getGroupListByFlow(Flow flow);

    List<Group> getAllWithSimilarName(String nameLecturer);
}
