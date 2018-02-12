package by.bsac.server.api.date.dto;

import by.bsac.server.api.date.entity.Group;

import java.util.Collection;

public class FlowDTO {

    private short idFlow;
    private String name;
    private Collection<GroupDTO> groupsByIdFlow;

    public FlowDTO() {
    }

    public FlowDTO(short idFlow, String name, Collection<GroupDTO> groupsByIdFlow) {
        this.idFlow = idFlow;
        this.name = name;
        this.groupsByIdFlow = groupsByIdFlow;
    }

    public short getIdFlow() {
        return idFlow;
    }

    public void setIdFlow(short idFlow) {
        this.idFlow = idFlow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<GroupDTO> getGroupsByIdFlow() {
        return groupsByIdFlow;
    }

    public void setGroupsByIdFlow(Collection<GroupDTO> groupsByIdFlow) {
        this.groupsByIdFlow = groupsByIdFlow;
    }
}
