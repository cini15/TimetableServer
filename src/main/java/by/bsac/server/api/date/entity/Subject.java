package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject",schema = "timetable")
public class Subject {
    private Short idSubject;
    private String nameSubject;
    private Byte idChair;
    private Byte eduLevel;
    private String abnameSubject;
    private Collection<Record> recordsByIdSubject;
    private Chair chairByIdChair;

    @Id
    @Column(name = "id_subject", nullable = false)
    public Short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Short idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "name_subject", nullable = false, length = 80)
    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    @Basic
    @Column(name = "id_chair", nullable = false,insertable = false,updatable = false)
    public Byte getIdChair() {
        return idChair;
    }

    public void setIdChair(Byte idChair) {
        this.idChair = idChair;
    }

    @Basic
    @Column(name = "edu_level", nullable = false)
    public Byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    @Basic
    @Column(name = "abname_subject", nullable = false, length = 20)
    public String getAbnameSubject() {
        return abnameSubject;
    }

    public void setAbnameSubject(String abnameSubject) {
        this.abnameSubject = abnameSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (!idSubject.equals(subject.idSubject)) return false;
        if (!nameSubject.equals(subject.nameSubject)) return false;
        if (!idChair.equals(subject.idChair)) return false;
        if (!eduLevel.equals(subject.eduLevel)) return false;
        if (!abnameSubject.equals(subject.abnameSubject)) return false;
        if (!recordsByIdSubject.equals(subject.recordsByIdSubject)) return false;
        return chairByIdChair.equals(subject.chairByIdChair);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSubject, nameSubject, idChair, eduLevel, abnameSubject);
    }

    @OneToMany(mappedBy = "subjectByIdSubject")
    public Collection<Record> getRecordsByIdSubject() {
        return recordsByIdSubject;
    }

    public void setRecordsByIdSubject(Collection<Record> recordsByIdSubject) {
        this.recordsByIdSubject = recordsByIdSubject;
    }

    @ManyToOne
    @JoinColumn(name = "id_chair", referencedColumnName = "id_chair", nullable = false)
    public Chair getChairByIdChair() {
        return chairByIdChair;
    }

    public void setChairByIdChair(Chair chairByIdChair) {
        this.chairByIdChair = chairByIdChair;
    }
}
