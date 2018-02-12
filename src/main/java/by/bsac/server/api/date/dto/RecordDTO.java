package by.bsac.server.api.date.dto;


import java.sql.Date;
import java.util.Collection;

public class RecordDTO {

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
    private Collection<CancellationDTO> cancellationsByIdRecord;
    private GroupDTO groupByIdGroup;
    private SubjectDTO subjectByIdSubject;
    private LecturerDTO lecturerByIdLecturer;
    private SubjectTypeDTO subjectTypeByIdSubjectType;
    private SubjectForDTO subjectForByIdSubjectFor;
    private ClassroomDTO classroomByIdClassroom;

    public RecordDTO() {
    }

    public RecordDTO(int idRecord, byte weekNumber, byte weekDay, byte subjOrdinalNumber, short idGroup, short idSubject, short idLecturer, byte idSubjectType, byte idSubjectFor, Date dateFrom, Date dateTo, short idClassroom, Collection<CancellationDTO> cancellationsByIdRecord, GroupDTO groupByIdGroup, SubjectDTO subjectByIdSubject, LecturerDTO lecturerByIdLecturer, SubjectTypeDTO subjectTypeByIdSubjectType, SubjectForDTO subjectForByIdSubjectFor, ClassroomDTO classroomByIdClassroom) {
        this.idRecord = idRecord;
        this.weekNumber = weekNumber;
        this.weekDay = weekDay;
        this.subjOrdinalNumber = subjOrdinalNumber;
        this.idGroup = idGroup;
        this.idSubject = idSubject;
        this.idLecturer = idLecturer;
        this.idSubjectType = idSubjectType;
        this.idSubjectFor = idSubjectFor;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.idClassroom = idClassroom;
        this.cancellationsByIdRecord = cancellationsByIdRecord;
        this.groupByIdGroup = groupByIdGroup;
        this.subjectByIdSubject = subjectByIdSubject;
        this.lecturerByIdLecturer = lecturerByIdLecturer;
        this.subjectTypeByIdSubjectType = subjectTypeByIdSubjectType;
        this.subjectForByIdSubjectFor = subjectForByIdSubjectFor;
        this.classroomByIdClassroom = classroomByIdClassroom;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public byte getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(byte weekNumber) {
        this.weekNumber = weekNumber;
    }

    public byte getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(byte weekDay) {
        this.weekDay = weekDay;
    }

    public byte getSubjOrdinalNumber() {
        return subjOrdinalNumber;
    }

    public void setSubjOrdinalNumber(byte subjOrdinalNumber) {
        this.subjOrdinalNumber = subjOrdinalNumber;
    }

    public short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(short idGroup) {
        this.idGroup = idGroup;
    }

    public short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(short idSubject) {
        this.idSubject = idSubject;
    }

    public short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(short idLecturer) {
        this.idLecturer = idLecturer;
    }

    public byte getIdSubjectType() {
        return idSubjectType;
    }

    public void setIdSubjectType(byte idSubjectType) {
        this.idSubjectType = idSubjectType;
    }

    public byte getIdSubjectFor() {
        return idSubjectFor;
    }

    public void setIdSubjectFor(byte idSubjectFor) {
        this.idSubjectFor = idSubjectFor;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(short idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Collection<CancellationDTO> getCancellationsByIdRecord() {
        return cancellationsByIdRecord;
    }

    public void setCancellationsByIdRecord(Collection<CancellationDTO> cancellationsByIdRecord) {
        this.cancellationsByIdRecord = cancellationsByIdRecord;
    }

    public GroupDTO getGroupByIdGroup() {
        return groupByIdGroup;
    }

    public void setGroupByIdGroup(GroupDTO groupByIdGroup) {
        this.groupByIdGroup = groupByIdGroup;
    }

    public SubjectDTO getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(SubjectDTO subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }

    public LecturerDTO getLecturerByIdLecturer() {
        return lecturerByIdLecturer;
    }

    public void setLecturerByIdLecturer(LecturerDTO lecturerByIdLecturer) {
        this.lecturerByIdLecturer = lecturerByIdLecturer;
    }

    public SubjectTypeDTO getSubjectTypeByIdSubjectType() {
        return subjectTypeByIdSubjectType;
    }

    public void setSubjectTypeByIdSubjectType(SubjectTypeDTO subjectTypeByIdSubjectType) {
        this.subjectTypeByIdSubjectType = subjectTypeByIdSubjectType;
    }

    public SubjectForDTO getSubjectForByIdSubjectFor() {
        return subjectForByIdSubjectFor;
    }

    public void setSubjectForByIdSubjectFor(SubjectForDTO subjectForByIdSubjectFor) {
        this.subjectForByIdSubjectFor = subjectForByIdSubjectFor;
    }

    public ClassroomDTO getClassroomByIdClassroom() {
        return classroomByIdClassroom;
    }

    public void setClassroomByIdClassroom(ClassroomDTO classroomByIdClassroom) {
        this.classroomByIdClassroom = classroomByIdClassroom;
    }
}
