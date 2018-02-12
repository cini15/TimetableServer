package by.bsac.server.api.date.dto;


import java.util.Collection;

public class SubjectForDTO {

    private byte id;
    private String name;
    private Collection<RecordDTO> recordsById;

    public SubjectForDTO() {
    }

    public SubjectForDTO(byte id, String name, Collection<RecordDTO> recordsById) {
        this.id = id;
        this.name = name;
        this.recordsById = recordsById;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<RecordDTO> getRecordsById() {
        return recordsById;
    }

    public void setRecordsById(Collection<RecordDTO> recordsById) {
        this.recordsById = recordsById;
    }
}
