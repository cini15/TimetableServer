package by.bsac.server.api.servise.dao;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Faculty;

import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.date.entity.Subject;

import java.util.Collection;
import java.util.List;

public interface TimetableDAO {
    public Collection<Faculty> getListFacultyAndGroups();
    public Collection<Record> getListRecords();
    public Collection<Chair> getLisChairsAndLecturers();
    public Collection<Subject> getListSubjects();
}
