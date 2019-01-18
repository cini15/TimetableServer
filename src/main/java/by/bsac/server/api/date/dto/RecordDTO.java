package by.bsac.server.api.date.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;
import java.util.Collection;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordDTO {

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
    private Collection<CancellationDTO> cancellationsByIdRecord;
    private SubjectTypeDTO subjectTypeByIdSubjectType;
    private SubjectForDTO subjectForByIdSubjectFor;
    private ClassroomDTO classroomByIdClassroom;

    public RecordDTO() {
    }

    public RecordDTO(Integer idRecord, Byte weekNumber, Byte weekDay, Byte subjOrdinalNumber, Short idGroup, Short idSubject, Short idLecturer, Byte idSubjectType, Byte idSubjectFor, Date dateFrom, Date dateTo, Short idClassroom, Collection<CancellationDTO> cancellationsByIdRecord, SubjectTypeDTO subjectTypeByIdSubjectType, SubjectForDTO subjectForByIdSubjectFor, ClassroomDTO classroomByIdClassroom) {
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
        this.subjectTypeByIdSubjectType = subjectTypeByIdSubjectType;
        this.subjectForByIdSubjectFor = subjectForByIdSubjectFor;
        this.classroomByIdClassroom = classroomByIdClassroom;
    }

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public Byte getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Byte weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Byte getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Byte weekDay) {
        this.weekDay = weekDay;
    }

    public Byte getSubjOrdinalNumber() {
        return subjOrdinalNumber;
    }

    public void setSubjOrdinalNumber(Byte subjOrdinalNumber) {
        this.subjOrdinalNumber = subjOrdinalNumber;
    }

    public Short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Short idGroup) {
        this.idGroup = idGroup;
    }

    public Short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Short idSubject) {
        this.idSubject = idSubject;
    }

    public Short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(Short idLecturer) {
        this.idLecturer = idLecturer;
    }

    public Byte getIdSubjectType() {
        return idSubjectType;
    }

    public void setIdSubjectType(Byte idSubjectType) {
        this.idSubjectType = idSubjectType;
    }

    public Byte getIdSubjectFor() {
        return idSubjectFor;
    }

    public void setIdSubjectFor(Byte idSubjectFor) {
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

    public Short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(Short idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Collection<CancellationDTO> getCancellationsByIdRecord() {
        return cancellationsByIdRecord;
    }

    public void setCancellationsByIdRecord(Collection<CancellationDTO> cancellationsByIdRecord) {
        this.cancellationsByIdRecord = cancellationsByIdRecord;
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
