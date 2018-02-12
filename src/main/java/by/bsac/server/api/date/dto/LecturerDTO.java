package by.bsac.server.api.date.dto;




import java.util.Collection;

public class LecturerDTO{

    private short idLecturer;
    private String nameLecturer;
    private byte idChair;
    private ChairDTO chairByIdChair;
    private Collection<RecordDTO> recordsByIdLecture;

    public LecturerDTO() {
    }

    public LecturerDTO(short idLecturer, String nameLecturer, byte idChair, ChairDTO chairByIdChair, Collection<RecordDTO> recordsByIdLecture) {
        this.idLecturer = idLecturer;
        this.nameLecturer = nameLecturer;
        this.idChair = idChair;
        this.chairByIdChair = chairByIdChair;
        this.recordsByIdLecture = recordsByIdLecture;
    }

    public short getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(short idLecturer) {
        this.idLecturer = idLecturer;
    }

    public String getNameLecturer() {
        return nameLecturer;
    }

    public void setNameLecturer(String nameLecturer) {
        this.nameLecturer = nameLecturer;
    }

    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

    public ChairDTO getChairByIdChair() {
        return chairByIdChair;
    }

    public void setChairByIdChair(ChairDTO chairByIdChair) {
        this.chairByIdChair = chairByIdChair;
    }

    public Collection<RecordDTO> getRecordsByIdLecture() {
        return recordsByIdLecture;
    }

    public void setRecordsByIdLecture(Collection<RecordDTO> recordsByIdLecture) {
        this.recordsByIdLecture = recordsByIdLecture;
    }
}
