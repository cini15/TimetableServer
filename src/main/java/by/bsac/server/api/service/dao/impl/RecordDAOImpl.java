package by.bsac.server.api.service.dao.impl;

import by.bsac.server.api.date.entity.*;
import by.bsac.server.api.service.dao.interfaces.RecordDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RecordDAOImpl extends AbstractDAO<Record,Integer> implements RecordDAO {

    private static final Logger log= LoggerFactory.getLogger(RecordDAOImpl.class);
    protected RecordDAOImpl() {
        super(Record.class);
    }

    @Override
    public List<Record> getRecordListByGroupAndDatesWhichNotCancelled(Group group, Date dateFrom, Date dateTo) {
        log.debug("getRecordListByGroupAndDatesWhichNotCancelled group: "+group+" dateFrom: "+dateFrom+ " dateTo: "+dateTo);
        return manager
                .createQuery("SELECT distinct rec FROM Record as rec "
                        + "LEFT JOIN rec.cancellationsByIdRecord can "
                        + "WHERE rec.idRecord not in "
                        + "(SELECT cans.recordByIdRecord.idRecord FROM Cancellation cans "
                        + "WHERE (:dateFrom BETWEEN cans.dateFrom AND cans.dateTo) "
                        + "OR (:dateTo BETWEEN cans.dateFrom AND cans.dateTo) "
                        + "OR (:dateFrom <= cans.dateFrom AND :dateTo >= cans.dateTo)) "
                        + "AND rec.groupByIdGroup =:group "
                        + "AND ((:dateFrom BETWEEN rec.dateFrom AND rec.dateTo) "
                        + "OR (:dateTo BETWEEN rec.dateFrom AND rec.dateTo) "
                        + "OR (:dateFrom <= rec.dateFrom AND :dateTo >= rec.dateTo))", Record.class)
                .setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo)
                .setParameter("group", group).getResultList();
    }

    @Override
    public Record getRecordForGroupLikeThis(Group group, Record record) {
        log.debug("getRecordForGroupLikeThis: group=" + group + "record=" + record);
        return manager
                .createQuery("select rec from Record as rec where rec.groupByIdGroup = :group and "
                        + "rec.weekNumber =:weekNumber and rec.weekDay =:weekDay and "
                        + "rec.subjOrdinalNumber =:subjOrdinalNumber and rec.dateFrom =:dateFrom and "
                        + "rec.dateTo =:dateTo", Record.class)
                .setParameter("group", group).setParameter("weekNumber", record.getWeekNumber())
                .setParameter("weekDay", record.getWeekDay())
                .setParameter("subjOrdinalNumber", record.getSubjOrdinalNumber())
                .setParameter("dateFrom", record.getDateFrom()).setParameter("dateTo", record.getDateTo())
                .getSingleResult();
    }

    @Override
    public List<Record> getRecordListByGroupAndSubjectFor(Group group, SubjectFor subjectFor) {
        log.debug("getRecordListByGroupAndSubjectFor: group=" + group + "subjectFor=" + subjectFor);
        return manager
                .createQuery(
                        "select rec from Record rec where rec.groupByIdGroup =:group and rec.subjectForByIdSubjectFor =:subjectFor",
                        Record.class)
                .setParameter("group", group)
                .setParameter("subjectFor", subjectFor).getResultList();
    }

    @Override
    public void replaceClassroomForAllRecords(Classroom oldClassroom, Classroom newClassroom) {
        log.debug("replaceClassroom: [oldClassroom= " + oldClassroom + ", newClassroom= "
                + newClassroom + "]");
        manager
                .createNativeQuery(
                        "UPDATE record as rec SET rec.id_classroom =:newId WHERE rec.id_classroom =:oldId")
                .setParameter("newId", newClassroom.getIdClassroom())
                .setParameter("oldId", oldClassroom.getIdClassroom()).executeUpdate();
    }

    @Override
    public void replaceLecturerForAllRecords(Lecturer oldLecturer, Lecturer newLecturer) {
        log.debug(
                "replaceLecturer: [oldLecturer= " + oldLecturer + ", newLecturer= " + newLecturer + "]");
        manager
                .createNativeQuery(
                        "UPDATE record as rec SET rec.id =:newId WHERE rec.id_lecturer =:oldId")
                .setParameter("newId", newLecturer.getIdLecturer())
                .setParameter("oldId", oldLecturer.getIdLecturer())
                .executeUpdate();
    }

    @Override
    public void deleteAllRecordsByFlow(Flow flow) {
        manager.createNativeQuery(
                "delete from record where record.id_group "
                        + "in (select id_group from `group` join flow where flow.id_flow = 1) and record.id_subject_for :=idSubjectFor")
                .setParameter("idFlow", flow.getIdFlow())
                .setParameter("subjectFor", (byte)4)
                .executeUpdate();
    }
}
