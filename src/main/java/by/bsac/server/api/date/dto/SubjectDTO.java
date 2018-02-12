package by.bsac.server.api.date.dto;

import java.util.Collection;

public class SubjectDTO {
    private short idSubject;
    private String nameSubject;
    private byte idChair;
    private byte eduLevel;
    private String abnameSubject;
    private Collection<RecordDTO> recordsByIdSubject;
    private ChairDTO chairByIdChair;

    public SubjectDTO() {
    }

    public SubjectDTO(short idSubject, String nameSubject, byte idChair, byte eduLevel, String abnameSubject, Collection<RecordDTO> recordsByIdSubject, ChairDTO chairByIdChair) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.idChair = idChair;
        this.eduLevel = eduLevel;
        this.abnameSubject = abnameSubject;
        this.recordsByIdSubject = recordsByIdSubject;
        this.chairByIdChair = chairByIdChair;
    }

    public short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(short idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

    public byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getAbnameSubject() {
        return abnameSubject;
    }

    public void setAbnameSubject(String abnameSubject) {
        this.abnameSubject = abnameSubject;
    }

    public Collection<RecordDTO> getRecordsByIdSubject() {
        return recordsByIdSubject;
    }

    public void setRecordsByIdSubject(Collection<RecordDTO> recordsByIdSubject) {
        this.recordsByIdSubject = recordsByIdSubject;
    }

    public ChairDTO getChairByIdChair() {
        return chairByIdChair;
    }

    public void setChairByIdChair(ChairDTO chairByIdChair) {
        this.chairByIdChair = chairByIdChair;
    }
}
