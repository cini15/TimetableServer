package by.bsac.server.api.date.dto;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChairDTO {

    private byte idChair;
    private String nameChair;
    @JsonProperty("lecturers")
    private Collection<LecturerDTO> lecturersByIdChair;
    @JsonProperty("subjects")
    private Collection<SubjectDTO> subjectsByIdChair;

    public ChairDTO(byte idChair, String nameChair, Collection<LecturerDTO> lecturersByIdChair, Collection<SubjectDTO> subjectsByIdChair) {
        this.idChair = idChair;
        this.nameChair = nameChair;
        this.lecturersByIdChair = lecturersByIdChair;
        this.subjectsByIdChair = subjectsByIdChair;
    }

    public ChairDTO() {
    }

    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

    public String getNameChair() {
        return nameChair;
    }

    public void setNameChair(String nameChair) {
        this.nameChair = nameChair;
    }

    public Collection<LecturerDTO> getLecturersByIdChair() {
        return lecturersByIdChair;
    }

    public void setLecturersByIdChair(Collection<LecturerDTO> lecturersByIdChair) {
        this.lecturersByIdChair = lecturersByIdChair;
    }

    public Collection<SubjectDTO> getSubjectsByIdChair() {
        return subjectsByIdChair;
    }

    public void setSubjectsByIdChair(Collection<SubjectDTO> subjectsByIdChair) {
        this.subjectsByIdChair = subjectsByIdChair;
    }
}
