package by.bsac.server.api.servise.dao.interfaces;

import by.bsac.server.api.date.entity.Classroom;
import by.bsac.server.api.date.entity.Group;
import by.bsac.server.api.date.entity.Record;

import java.util.Date;
import java.util.List;

public interface ClassroomDAO {
    void add(Classroom chair);

    void addAll(List<Classroom> listClassroom);

    void update(Classroom chair);

    void updateAll(List<Classroom> listClassroom);

    Classroom getById(Short idChair);

    List<Classroom> getAll();

    void delete(Classroom chair);

    List<Classroom> getClassroomListForGroupByDates(Group group, Date dateFrom, Date dateTo);

    List<Classroom> getReservedClassroomListByDatesAndRecord(Date dateFrom, Date dateTo,
                                                             Record record);
}
