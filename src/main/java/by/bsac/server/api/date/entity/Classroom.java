package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classroom",schema = "timetable")
public class Classroom {
    private short idClassroom;
    private short number;
    private byte building;
    private Collection<Record> recordsByIdClassroom;

    @Id
    @Column(name = "id_classroom", nullable = false)
    public short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(short idClassroom) {
        this.idClassroom = idClassroom;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    @Basic
    @Column(name = "building", nullable = false)
    public byte getBuilding() {
        return building;
    }

    public void setBuilding(byte building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return idClassroom == classroom.idClassroom &&
                number == classroom.number &&
                building == classroom.building;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idClassroom, number, building);
    }

    @OneToMany(mappedBy = "classroomByIdClassroom")
    public Collection<Record> getRecordsByIdClassroom() {
        return recordsByIdClassroom;
    }

    public void setRecordsByIdClassroom(Collection<Record> recordsByIdClassroom) {
        this.recordsByIdClassroom = recordsByIdClassroom;
    }
}
