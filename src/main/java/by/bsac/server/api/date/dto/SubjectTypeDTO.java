package by.bsac.server.api.date.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectTypeDTO {
    private byte id;
    private String name;

    public SubjectTypeDTO() {
    }

    public SubjectTypeDTO(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
