package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lecturer",schema = "timetable")
public class Lecturer {
    private Short idLecturer;
    private String nameLecturer;
    private Byte idChair;
    private Chair chairByIdChair;
    private Collection<Record> recordsByIdLecturer;

    @Id
    @Column(name = "id_lecturer", nullable = false)
    public Short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(Short idLecturer) {
        this.idLecturer = idLecturer;
    }

    @Basic
    @Column(name = "name_lecturer", nullable = false, length = 45)
    public String getNameLecturer() {
        return nameLecturer;
    }

    public void setNameLecturer(String nameLecturer) {
        this.nameLecturer = nameLecturer;
    }

    @Basic
    @Column(name = "id_chair", nullable = false,insertable = false,updatable = false)
    public Byte getIdChair() {
        return idChair;
    }

    public void setIdChair(Byte idChair) {
        this.idChair = idChair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return idLecturer.equals(lecturer.idLecturer) &&
                idChair.equals(lecturer.idChair) &&
                Objects.equals(nameLecturer, lecturer.nameLecturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLecturer, nameLecturer, idChair);
    }

    @ManyToOne
    @JoinColumn(name = "id_chair", referencedColumnName = "id_chair", nullable = false)
    public Chair getChairByIdChair() {
        return chairByIdChair;
    }

    public void setChairByIdChair(Chair chairByIdChair) {
        this.chairByIdChair = chairByIdChair;
    }

    @OneToMany(mappedBy = "lecturerByIdLecturer")
    public Collection<Record> getRecordsByIdLecturer() {
        return recordsByIdLecturer;
    }

    public void setRecordsByIdLecturer(Collection<Record> recordsByIdLecturer) {
        this.recordsByIdLecturer = recordsByIdLecturer;
    }
}
