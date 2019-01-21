package by.bsac.server.api.service.dao;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Faculty;

import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.date.entity.Subject;

import java.util.Collection;

public interface TimetableDAO {
    Collection<Faculty> getListFacultyAndGroups();
    Collection<Record> getListRecords();
    Collection<Chair> getLisChairsAndLecturers();
    Collection<Subject> getListSubjects();

}
