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

    public RecordDTO() {
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

}
