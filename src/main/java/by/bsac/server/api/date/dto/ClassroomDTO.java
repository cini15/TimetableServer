package by.bsac.server.api.date.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassroomDTO {

    private Short idClassroom;
    private Short number;
    private Byte building;
    public ClassroomDTO() {
    }

    public ClassroomDTO(short idClassroom, short number, byte building) {
        this.idClassroom = idClassroom;
        this.number = number;
        this.building = building;

    }

    public ClassroomDTO(Short idClassroom, Short number, Byte building) {
        this.idClassroom = idClassroom;
        this.number = number;
        this.building = building;
    }

    public Short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(Short idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public Byte getBuilding() {
        return building;
    }

    public void setBuilding(Byte building) {
        this.building = building;
    }

}
