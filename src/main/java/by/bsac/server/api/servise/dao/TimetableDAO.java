package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Group;

import java.util.List;

public interface TimetableDAO {
    public List<Faculty> getListFaculty();
    public List<Group> getLisGroup();
}
