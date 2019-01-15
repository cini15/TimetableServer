package by.bsac.server.api.servise;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.date.entity.Subject;

import java.util.Collection;
import java.util.List;

public interface TimetableServise {
    Collection<Faculty>getFacultyList();
    Collection<Record> getRecordsList();
    Collection<Chair> getChairsList();
    Collection<Subject> getSubjectsList();


}
