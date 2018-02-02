package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject",schema = "timetable")
public class Subject {
    private short idSubject;
    private String nameSubject;
    private byte idChair;
    private byte eduLevel;
    private String abnameSubject;
    private Collection<Record> recordsByIdSubject;
    private Chair chairByIdChair;

    @Id
    @Column(name = "id_subject", nullable = false)
    public short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(short idSubject) {
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
    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

    @Basic
    @Column(name = "edu_level", nullable = false)
    public byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(byte eduLevel) {
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
        return idSubject == subject.idSubject &&
                idChair == subject.idChair &&
                eduLevel == subject.eduLevel &&
                Objects.equals(nameSubject, subject.nameSubject) &&
                Objects.equals(abnameSubject, subject.abnameSubject);
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
