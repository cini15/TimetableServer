package by.bsac.server.api.date.dto;

public class FlowDTO {

    private Short idFlow;
    private String name;

    public FlowDTO() {
    }

    public FlowDTO(Short idFlow, String name) {
        this.idFlow = idFlow;
        this.name = name;
    }

    public FlowDTO(short idFlow, String name) {
        this.idFlow = idFlow;
        this.name = name;
    }

    public Short getIdFlow() {
        return idFlow;
    }

    public void setIdFlow(Short idFlow) {
        this.idFlow = idFlow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
