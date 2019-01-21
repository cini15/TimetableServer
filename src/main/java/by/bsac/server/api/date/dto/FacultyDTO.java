package by.bsac.server.api.date.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacultyDTO {
    private Byte idFaculty;
    private String nameFaculty;

    public FacultyDTO() {
    }

    public FacultyDTO(byte idFaculty, String nameFaculty) {
        this.idFaculty = idFaculty;
        this.nameFaculty = nameFaculty;

    }

    public Byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }


}
