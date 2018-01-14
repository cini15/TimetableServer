package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Flow {
    private short idFlow;
    private String name;
    private Collection<Group> groupsByIdFlow;

    @Id
    @Column(name = "id_flow", nullable = false)
    public short getIdFlow() {
        return idFlow;
    }

    public void setIdFlow(short idFlow) {
        this.idFlow = idFlow;
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
        Flow flow = (Flow) o;
        return idFlow == flow.idFlow &&
                Objects.equals(name, flow.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFlow, name);
    }

    @OneToMany(mappedBy = "flowByIdFlow")
    public Collection<Group> getGroupsByIdFlow() {
        return groupsByIdFlow;
    }

    public void setGroupsByIdFlow(Collection<Group> groupsByIdFlow) {
        this.groupsByIdFlow = groupsByIdFlow;
    }
}
