package by.bsac.server.api.date.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;



@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GroupDTO {
    private short idGroup;
    private String nameGroup;
    private Short idFlow;
    private byte idFaculty;
    private byte eduLevel;
    private FlowDTO flowByIdFlow;

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

    public FlowDTO getFlowByIdFlow() {
        return flowByIdFlow;
    }

    public void setFlowByIdFlow(FlowDTO flowByIdFlow) {
        this.flowByIdFlow = flowByIdFlow;
    }

}
