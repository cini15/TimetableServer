package by.bsac.server.api.service.dao.interfaces;

import by.bsac.server.api.date.entity.*;

import java.util.Date;
import java.util.List;

public interface RecordDAO {
    void add(Record mainRecord);

    void addAll(List<Record> listRecord);

    void update(Record mainRecord);

    void updateAll(List<Record> listRecord);

    Record getById(Integer idRecord);

    List<Record> getAll();

    void delete(Record mainRecord);

    void deleteAll(List<Record> recordList);

    List<Record> getRecordListByGroupAndDatesWhichNotCancelled(Group group, Date dateFrom,
                                                               Date dateTo);

    Record getRecordForGroupLikeThis(Group group, Record record);

    List<Record> getRecordListByGroupAndSubjectFor(Group group, SubjectFor subjectFor);

    void replaceClassroomForAllRecords(Classroom oldClassroom, Classroom newClassroom);

    void replaceLecturerForAllRecords(Lecturer oldLecturer, Lecturer newLecturer);

    void deleteAllRecordsByFlow(Flow flow);
}
