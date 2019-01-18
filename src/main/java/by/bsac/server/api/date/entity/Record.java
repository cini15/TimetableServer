package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "record",schema = "timetable")
public class Record {
    private Integer idRecord;
    private Byte weekNumber;
    private Byte weekDay;
    private Byte subjOrdinalNumber;
    private Short idGroup;
    private Short idSubject;
    private Short idLecturer;
    private Byte idSubjectType;
    private Byte idSubjectFor;
    private Date dateFrom;
    private Date dateTo;
    private Short idClassroom;
    private Collection<Cancellation> cancellationsByIdRecord;
    private Group groupByIdGroup;
    private Subject subjectByIdSubject;
    private Lecturer lecturerByIdLecturer;
    private SubjectType subjectTypeByIdSubjectType;
    private SubjectFor subjectForByIdSubjectFor;
    private Classroom classroomByIdClassroom;

    @Id
    @Column(name = "id_record", nullable = false)
    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    @Basic
    @Column(name = "week_number", nullable = false)
    public Byte getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Byte weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Basic
    @Column(name = "week_day", nullable = false)
    public Byte getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Byte weekDay) {
        this.weekDay = weekDay;
    }

    @Basic
    @Column(name = "subj_ordinal_number", nullable = false)
    public Byte getSubjOrdinalNumber() {
        return subjOrdinalNumber;
    }

    public void setSubjOrdinalNumber(Byte subjOrdinalNumber) {
        this.subjOrdinalNumber = subjOrdinalNumber;
    }

    @Basic
    @Column(name = "id_group", nullable = false,insertable = false,updatable = false)
    public Short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Short idGroup) {
        this.idGroup = idGroup;
    }

    @Basic
    @Column(name = "id_subject", nullable = false,insertable = false,updatable = false)
    public Short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Short idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "id_lecturer", nullable = false,insertable = false,updatable = false)
    public Short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(Short idLecturer) {
        this.idLecturer = idLecturer;
    }

    @Basic
    @Column(name = "id_subject_type", nullable = false,insertable = false,updatable = false)
    public Byte getIdSubjectType() {
        return idSubjectType;
    }

    public void setIdSubjectType(Byte idSubjectType) {
        this.idSubjectType = idSubjectType;
    }

    @Basic
    @Column(name = "id_subject_for", nullable = false,insertable = false,updatable = false)
    public Byte getIdSubjectFor() {
        return idSubjectFor;
    }

    public void setIdSubjectFor(Byte idSubjectFor) {
        this.idSubjectFor = idSubjectFor;
    }

    @Basic
    @Column(name = "date_from", nullable = false)
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "date_to", nullable = false)
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Basic
    @Column(name = "id_classroom", nullable = false,insertable = false,updatable = false)
    public Short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(Short idClassroom) {
        this.idClassroom = idClassroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (!idRecord.equals(record.idRecord)) return false;
        if (!weekNumber.equals(record.weekNumber)) return false;
        if (!weekDay.equals(record.weekDay)) return false;
        if (!subjOrdinalNumber.equals(record.subjOrdinalNumber)) return false;
        if (!idGroup.equals(record.idGroup)) return false;
        if (!idSubject.equals(record.idSubject)) return false;
        if (!idLecturer.equals(record.idLecturer)) return false;
        if (!idSubjectType.equals(record.idSubjectType)) return false;
        if (!idSubjectFor.equals(record.idSubjectFor)) return false;
        if (!dateFrom.equals(record.dateFrom)) return false;
        if (!dateTo.equals(record.dateTo)) return false;
        if (!idClassroom.equals(record.idClassroom)) return false;
        if (!cancellationsByIdRecord.equals(record.cancellationsByIdRecord)) return false;
        if (!groupByIdGroup.equals(record.groupByIdGroup)) return false;
        if (!subjectByIdSubject.equals(record.subjectByIdSubject)) return false;
        if (!lecturerByIdLecturer.equals(record.lecturerByIdLecturer)) return false;
        if (!subjectTypeByIdSubjectType.equals(record.subjectTypeByIdSubjectType)) return false;
        if (!subjectForByIdSubjectFor.equals(record.subjectForByIdSubjectFor)) return false;
        return classroomByIdClassroom.equals(record.classroomByIdClassroom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRecord, weekNumber, weekDay, subjOrdinalNumber, idGroup, idSubject, idLecturer, idSubjectType, idSubjectFor, dateFrom, dateTo, idClassroom);
    }

    @OneToMany(mappedBy = "recordByIdRecord")
    public Collection<Cancellation> getCancellationsByIdRecord() {
        return cancellationsByIdRecord;
    }

    public void setCancellationsByIdRecord(Collection<Cancellation> cancellationsByIdRecord) {
        this.cancellationsByIdRecord = cancellationsByIdRecord;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", referencedColumnName = "id_group", nullable = false)
    public Group getGroupByIdGroup() {
        return groupByIdGroup;
    }

    public void setGroupByIdGroup(Group groupByIdGroup) {
        this.groupByIdGroup = groupByIdGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject", nullable = false)
    public Subject getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(Subject subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lecturer", referencedColumnName = "id_lecturer", nullable = false)
    public Lecturer getLecturerByIdLecturer() {
        return lecturerByIdLecturer;
    }

    public void setLecturerByIdLecturer(Lecturer lecturerByIdLecturer) {
        this.lecturerByIdLecturer = lecturerByIdLecturer;
    }

    @ManyToOne
    @JoinColumn(name = "id_subject_type", referencedColumnName = "id", nullable = false)
    public SubjectType getSubjectTypeByIdSubjectType() {
        return subjectTypeByIdSubjectType;
    }

    public void setSubjectTypeByIdSubjectType(SubjectType subjectTypeByIdSubjectType) {
        this.subjectTypeByIdSubjectType = subjectTypeByIdSubjectType;
    }

    @ManyToOne
    @JoinColumn(name = "id_subject_for", referencedColumnName = "id", nullable = false)
    public SubjectFor getSubjectForByIdSubjectFor() {
        return subjectForByIdSubjectFor;
    }

    public void setSubjectForByIdSubjectFor(SubjectFor subjectForByIdSubjectFor) {
        this.subjectForByIdSubjectFor = subjectForByIdSubjectFor;
    }

    @ManyToOne
    @JoinColumn(name = "id_classroom", referencedColumnName = "id_classroom", nullable = false)
    public Classroom getClassroomByIdClassroom() {
        return classroomByIdClassroom;
    }

    public void setClassroomByIdClassroom(Classroom classroomByIdClassroom) {
        this.classroomByIdClassroom = classroomByIdClassroom;
    }
}
