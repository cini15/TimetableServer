package by.bsac.server.api.date.dto;




import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LecturerDTO{

    private Short idLecturer;
    private String nameLecturer;
    private Byte idChair;

    public LecturerDTO() {
    }

    public LecturerDTO(Short idLecturer, String nameLecturer, Byte idChair) {
        this.idLecturer = idLecturer;
        this.nameLecturer = nameLecturer;
        this.idChair = idChair;
    }

    public Short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(Short idLecturer) {
        this.idLecturer = idLecturer;
    }

    public String getNameLecturer() {
        return nameLecturer;
    }

    public void setNameLecturer(String nameLecturer) {
        this.nameLecturer = nameLecturer;
    }

    public Byte getIdChair() {
        return idChair;
    }

    public void setIdChair(Byte idChair) {
        this.idChair = idChair;
    }

}
