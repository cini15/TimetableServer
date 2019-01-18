package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject_for", schema = "timetable", catalog = "")
public class SubjectFor {
    private Byte id;
    private String name;
    private Collection<Record> recordsById;

    @Id
    @Column(name = "id", nullable = false)
    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectFor that = (SubjectFor) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return recordsById.equals(that.recordsById);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + recordsById.hashCode();
        return result;
    }

    @OneToMany(mappedBy = "subjectForByIdSubjectFor")
    public Collection<Record> getRecordsById() {
        return recordsById;
    }

    public void setRecordsById(Collection<Record> recordsById) {
        this.recordsById = recordsById;
    }
}
