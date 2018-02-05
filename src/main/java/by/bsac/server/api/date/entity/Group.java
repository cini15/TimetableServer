package by.bsac.server.api.date.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "`group`",schema = "timetable")
public class Group {
    private short idGroup;
    private String nameGroup;
    private Short idFlow;
    private byte idFaculty;
    private byte eduLevel;
    private Flow flowByIdFlow;
    private Faculty facultyByIdFaculty;
    private Collection<Record> recordsByIdGroup;

    @Id
    @Column(name = "id_group", nullable = false)
    public short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(short idGroup) {
        this.idGroup = idGroup;
    }

    @Basic
    @Column(name = "name_group", nullable = false, length = 45)
    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Basic
    @Column(name = "id_flow", nullable = true,insertable = false,updatable = false)
    public Short getIdFlow() {
        return idFlow;
    }

    public void setIdFlow(Short idFlow) {
        this.idFlow = idFlow;
    }

    @Basic
    @Column(name = "id_faculty", nullable = false,insertable = false,updatable = false)
    public byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Basic
    @Column(name = "edu_level", nullable = false)
    public byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return idGroup == group.idGroup &&
                idFaculty == group.idFaculty &&
                eduLevel == group.eduLevel &&
                Objects.equals(nameGroup, group.nameGroup) &&
                Objects.equals(idFlow, group.idFlow);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idGroup, nameGroup, idFlow, idFaculty, eduLevel);
    }

    @ManyToOne
    @JoinColumn(name = "id_flow", referencedColumnName = "id_flow")

    public Flow getFlowByIdFlow() {
        return flowByIdFlow;
    }

    public void setFlowByIdFlow(Flow flowByIdFlow) {
        this.flowByIdFlow = flowByIdFlow;
    }

    @ManyToOne
    @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty", nullable = false)
    public Faculty getFacultyByIdFaculty() {
        return facultyByIdFaculty;
    }

    public void setFacultyByIdFaculty(Faculty facultyByIdFaculty) {
        this.facultyByIdFaculty = facultyByIdFaculty;
    }

    @OneToMany(mappedBy = "groupByIdGroup",fetch = FetchType.LAZY)
    public Collection<Record> getRecordsByIdGroup() {
        return recordsByIdGroup;
    }

    public void setRecordsByIdGroup(Collection<Record> recordsByIdGroup) {
        this.recordsByIdGroup = recordsByIdGroup;
    }
}
