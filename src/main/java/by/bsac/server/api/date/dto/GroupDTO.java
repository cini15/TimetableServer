package by.bsac.server.api.date.dto;

public class GroupDTO {
    private short idGroup;
    private String nameGroup;
    private Short idFlow;
    private byte idFaculty;
    private byte eduLevel;

    public short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(short idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Short getIdFlow() {
        return idFlow;
    }

    public void setIdFlow(Short idFlow) {
        this.idFlow = idFlow;
    }

    public byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    public byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(byte eduLevel) {
        this.eduLevel = eduLevel;
    }
}
