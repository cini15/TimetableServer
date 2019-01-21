package by.bsac.server.api.service;

import by.bsac.server.api.date.entity.Chair;
import by.bsac.server.api.date.entity.Faculty;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.date.entity.Subject;

import java.util.List;

public interface TimetableServise {
    List<Faculty>getFacultyList();
    List<Record> getRecordsList();
    List<Chair> getChairsList();
    List<Subject> getSubjectsList();


}
