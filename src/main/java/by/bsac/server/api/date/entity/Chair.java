package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chair",schema = "timetable")
public class Chair {
    private byte idChair;
    private String nameChair;
    private Collection<Lecturer> lecturersByIdChair;
    private Collection<Subject> subjectsByIdChair;

    @Id
    @Column(name = "id_chair", nullable = false)
    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

    @Basic
    @Column(name = "name_chair", nullable = false, length = 70)
    public String getNameChair() {
        return nameChair;
    }

    public void setNameChair(String nameChair) {
        this.nameChair = nameChair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return idChair == chair.idChair &&
                Objects.equals(nameChair, chair.nameChair);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idChair, nameChair);
    }

    @OneToMany(mappedBy = "chairByIdChair")
    public Collection<Lecturer> getLecturersByIdChair() {
        return lecturersByIdChair;
    }

    public void setLecturersByIdChair(Collection<Lecturer> lecturersByIdChair) {
        this.lecturersByIdChair = lecturersByIdChair;
    }

    @OneToMany(mappedBy = "chairByIdChair")
    public Collection<Subject> getSubjectsByIdChair() {
        return subjectsByIdChair;
    }

    public void setSubjectsByIdChair(Collection<Subject> subjectsByIdChair) {
        this.subjectsByIdChair = subjectsByIdChair;
    }
}
