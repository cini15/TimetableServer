package by.bsac.server.api.date.dto;

import by.bsac.server.api.date.entity.Group;

import java.util.Collection;

public class FlowDTO {

    private short idFlow;
    private String name;

    public FlowDTO() {
    }

    public FlowDTO(short idFlow, String name) {
        this.idFlow = idFlow;
        this.name = name;
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

}
