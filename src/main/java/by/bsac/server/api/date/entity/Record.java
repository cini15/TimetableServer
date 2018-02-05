package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "record",schema = "timetable")
public class Record {
    private int idRecord;
    private byte weekNumber;
    private byte weekDay;
    private byte subjOrdinalNumber;
    private short idGroup;
    private short idSubject;
    private short idLecturer;
    private byte idSubjectType;
    private byte idSubjectFor;
    private Date dateFrom;
    private Date dateTo;
    private short idClassroom;
    private Collection<Cancellation> cancellationsByIdRecord;
    private Group groupByIdGroup;
    private Subject subjectByIdSubject;
    private Lecturer lecturerByIdLecturer;
    private SubjectType subjectTypeByIdSubjectType;
    private SubjectFor subjectForByIdSubjectFor;
    private Classroom classroomByIdClassroom;

    @Id
    @Column(name = "id_record", nullable = false)
    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    @Basic
    @Column(name = "week_number", nullable = false)
    public byte getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(byte weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Basic
    @Column(name = "week_day", nullable = false)
    public byte getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(byte weekDay) {
        this.weekDay = weekDay;
    }

    @Basic
    @Column(name = "subj_ordinal_number", nullable = false)
    public byte getSubjOrdinalNumber() {
        return subjOrdinalNumber;
    }

    public void setSubjOrdinalNumber(byte subjOrdinalNumber) {
        this.subjOrdinalNumber = subjOrdinalNumber;
    }

    @Basic
    @Column(name = "id_group", nullable = false,insertable = false,updatable = false)
    public short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(short idGroup) {
        this.idGroup = idGroup;
    }

    @Basic
    @Column(name = "id_subject", nullable = false,insertable = false,updatable = false)
    public short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(short idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "id_lecturer", nullable = false,insertable = false,updatable = false)
    public short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(short idLecturer) {
        this.idLecturer = idLecturer;
    }

    @Basic
    @Column(name = "id_subject_type", nullable = false,insertable = false,updatable = false)
    public byte getIdSubjectType() {
        return idSubjectType;
    }

    public void setIdSubjectType(byte idSubjectType) {
        this.idSubjectType = idSubjectType;
    }

    @Basic
    @Column(name = "id_subject_for", nullable = false,insertable = false,updatable = false)
    public byte getIdSubjectFor() {
        return idSubjectFor;
    }

    public void setIdSubjectFor(byte idSubjectFor) {
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
    public short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(short idClassroom) {
        this.idClassroom = idClassroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return idRecord == record.idRecord &&
                weekNumber == record.weekNumber &&
                weekDay == record.weekDay &&
                subjOrdinalNumber == record.subjOrdinalNumber &&
                idGroup == record.idGroup &&
                idSubject == record.idSubject &&
                idLecturer == record.idLecturer &&
                idSubjectType == record.idSubjectType &&
                idSubjectFor == record.idSubjectFor &&
                idClassroom == record.idClassroom &&
                Objects.equals(dateFrom, record.dateFrom) &&
                Objects.equals(dateTo, record.dateTo);
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

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id_group", nullable = false)
    public Group getGroupByIdGroup() {
        return groupByIdGroup;
    }

    public void setGroupByIdGroup(Group groupByIdGroup) {
        this.groupByIdGroup = groupByIdGroup;
    }

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject", nullable = false)
    public Subject getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(Subject subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }

    @ManyToOne
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
