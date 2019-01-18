package by.bsac.server.api.date.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDTO {
    private Short idSubject;
    private String nameSubject;
    private Byte idChair;
    private Byte eduLevel;
    private String abnameSubject;


    public SubjectDTO() {
    }

    public SubjectDTO(Short idSubject, String nameSubject, Byte idChair, Byte eduLevel, String abnameSubject) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.idChair = idChair;
        this.eduLevel = eduLevel;
        this.abnameSubject = abnameSubject;
    }



    public Short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Short idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public Byte getIdChair() {
        return idChair;
    }

    public void setIdChair(Byte idChair) {
        this.idChair = idChair;
    }

    public Byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getAbnameSubject() {
        return abnameSubject;
    }

    public void setAbnameSubject(String abnameSubject) {
        this.abnameSubject = abnameSubject;
    }

}
