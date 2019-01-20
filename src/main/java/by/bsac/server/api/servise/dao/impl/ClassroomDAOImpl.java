package by.bsac.server.api.servise.dao.impl;

import by.bsac.server.api.date.entity.Classroom;
import by.bsac.server.api.date.entity.Group;
import by.bsac.server.api.date.entity.Record;
import by.bsac.server.api.servise.dao.interfaces.ClassroomDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ClassroomDAOImpl extends AbstractDAO<Classroom,Short> implements ClassroomDAO {

    private static final Logger log= LoggerFactory.getLogger(ClassroomDAOImpl.class);
    protected ClassroomDAOImpl() {
        super(Classroom.class);
    }

    @Override
    public List<Classroom> getClassroomListForGroupByDates(Group group, Date dateFrom, Date dateTo) {
        log.debug("getClassroomListForGroupByDates "+ group+" date From "+dateFrom+ " date To "+ dateTo);



        return null;
    }

    @Override
    public List<Classroom> getReservedClassroomListByDatesAndRecord(Date dateFrom, Date dateTo, Record record) {
        log.debug("getReservedClassroomList: dateFrom=" + dateFrom + ",dateTo=" + dateTo);
        return manager
                .createQuery("SELECT distinct rec.classroomByIdClassroom FROM Record as rec "
                                + "LEFT JOIN rec.cancellationsByIdRecord can WHERE rec.idRecord not in "
                                + "(SELECT cans.recordByIdRecord.idRecord FROM Cancellation cans "
                                + "WHERE (:dateFrom BETWEEN cans.dateFrom AND cans.dateTo) "
                                + "OR (:dateTo BETWEEN cans.dateFrom AND cans.dateTo) "
                                + "OR (:dateFrom <= cans.dateFrom AND :dateTo >= cans.dateTo)) "
                                + "AND NOT (:dateTo < rec.dateFrom OR :dateFrom > rec.dateTo) "
                                + "AND rec.weekNumber =:weekNumber "
                                + "AND rec.weekDay =:weekDay "
                                + "AND rec.subjOrdinalNumber =:subjOrdinalNumber "
           /* + "AND ((:dateFrom BETWEEN rec.dateFrom AND rec.dateTo) "
            + "OR (:dateTo BETWEEN rec.dateFrom AND rec.dateTo) "
            + "OR (:dateFrom <= rec.dateFrom AND :dateTo >= rec.dateTo))"*/, Classroom.class)
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo)
                .setParameter("weekNumber", record.getWeekNumber())
                .setParameter("weekDay", record.getWeekDay())
                .setParameter("subjOrdinalNumber", record.getWeekDay())
                .getResultList();
    }
}
