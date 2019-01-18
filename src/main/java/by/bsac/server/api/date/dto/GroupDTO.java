package by.bsac.server.api.date.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GroupDTO {
    private Short idGroup;
    private String nameGroup;
    private Short idFlow;
    private Byte idFaculty;
    private Byte eduLevel;
    private FlowDTO flowByIdFlow;

    public Short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Short idGroup) {
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

    public Byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    public Byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    public FlowDTO getFlowByIdFlow() {
        return flowByIdFlow;
    }

    public void setFlowByIdFlow(FlowDTO flowByIdFlow) {
        this.flowByIdFlow = flowByIdFlow;
    }

}
