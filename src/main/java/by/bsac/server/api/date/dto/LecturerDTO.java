package by.bsac.server.api.date.dto;




import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LecturerDTO{

    private short idLecturer;
    private String nameLecturer;
    private byte idChair;

    public LecturerDTO() {
    }

    public LecturerDTO(short idLecturer, String nameLecturer, byte idChair) {
        this.idLecturer = idLecturer;
        this.nameLecturer = nameLecturer;
        this.idChair = idChair;

    }

    public short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(short idLecturer) {
        this.idLecturer = idLecturer;
    }

    public String getNameLecturer() {
        return nameLecturer;
    }

    public void setNameLecturer(String nameLecturer) {
        this.nameLecturer = nameLecturer;
    }

    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

}
