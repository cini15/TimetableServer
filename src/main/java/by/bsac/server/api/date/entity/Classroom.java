package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classroom",schema = "timetable")
public class Classroom {
    private Short idClassroom;
    private Short number;
    private Byte building;
    private Collection<Record> recordsByIdClassroom;

    @Id
    @Column(name = "id_classroom", nullable = false)
    public Short getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(Short idClassroom) {
        this.idClassroom = idClassroom;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    @Basic
    @Column(name = "building", nullable = false)
    public Byte getBuilding() {
        return building;
    }

    public void setBuilding(Byte building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classroom classroom = (Classroom) o;

        if (!idClassroom.equals(classroom.idClassroom)) return false;
        if (!number.equals(classroom.number)) return false;
        if (!building.equals(classroom.building)) return false;
        return recordsByIdClassroom.equals(classroom.recordsByIdClassroom);
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
