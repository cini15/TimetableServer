package by.bsac.server.api.date.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "`group`",schema = "timetable")
public class Group {
    private Short idGroup;
    private String nameGroup;
    private Short idFlow;
    private Byte idFaculty;
    private Byte eduLevel;
    private Flow flowByIdFlow;
    private Faculty facultyByIdFaculty;
    private Collection<Record> recordsByIdGroup;

    @Id
    @Column(name = "id_group", nullable = false)
    public Short getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Short idGroup) {
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
    public Byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Basic
    @Column(name = "edu_level", nullable = false)
    public Byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (!idGroup.equals(group.idGroup)) return false;
        if (!nameGroup.equals(group.nameGroup)) return false;
        if (!idFlow.equals(group.idFlow)) return false;
        if (!idFaculty.equals(group.idFaculty)) return false;
        if (!eduLevel.equals(group.eduLevel)) return false;
        if (!flowByIdFlow.equals(group.flowByIdFlow)) return false;
        if (!facultyByIdFaculty.equals(group.facultyByIdFaculty)) return false;
        return recordsByIdGroup.equals(group.recordsByIdGroup);
    }

    @Override
    public int hashCode() {
        int result = idGroup.hashCode();
        result = 31 * result + nameGroup.hashCode();
        result = 31 * result + idFlow.hashCode();
        result = 31 * result + idFaculty.hashCode();
        result = 31 * result + eduLevel.hashCode();
        result = 31 * result + flowByIdFlow.hashCode();
        result = 31 * result + facultyByIdFaculty.hashCode();
        result = 31 * result + recordsByIdGroup.hashCode();
        return result;
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
