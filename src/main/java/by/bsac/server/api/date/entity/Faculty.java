package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Faculty {
    private byte idFaculty;
    private String nameFaculty;
    private Collection<Group> groupsByIdFaculty;

    @Id
    @Column(name = "id_faculty", nullable = false)
    public byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Basic
    @Column(name = "name_faculty", nullable = false, length = 60)
    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return idFaculty == faculty.idFaculty &&
                Objects.equals(nameFaculty, faculty.nameFaculty);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFaculty, nameFaculty);
    }

    @OneToMany(mappedBy = "facultyByIdFaculty")
    public Collection<Group> getGroupsByIdFaculty() {
        return groupsByIdFaculty;
    }

    public void setGroupsByIdFaculty(Collection<Group> groupsByIdFaculty) {
        this.groupsByIdFaculty = groupsByIdFaculty;
    }
}
