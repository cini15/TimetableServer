package by.bsac.server.api.date.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacultyDTO {
    private byte idFaculty;
    private String nameFaculty;
    @JsonProperty("groups")
    private Collection<GroupDTO> groupsByIdFaculty=new ArrayList<>();

    public byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public Collection<GroupDTO> getGroupsByIdFaculty() {
        return groupsByIdFaculty;
    }

    public void setGroupsByIdFaculty(Collection<GroupDTO> groupsByIdFaculty) {
        this.groupsByIdFaculty = groupsByIdFaculty;
    }
}
