package by.bsac.server.api.date.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassroomDTO {

    private short idClassroom;
    private short number;
    private byte building;
    public ClassroomDTO() {
    }

    public ClassroomDTO(short idClassroom, short number, byte building) {
        this.idClassroom = idClassroom;
        this.number = number;
        this.building = building;

    }

    public short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(short idClassroom) {
        this.idClassroom = idClassroom;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public byte getBuilding() {
        return building;
    }

    public void setBuilding(byte building) {
        this.building = building;
    }

}
