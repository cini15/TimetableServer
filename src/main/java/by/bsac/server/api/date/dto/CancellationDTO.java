package by.bsac.server.api.date.dto;



import java.sql.Date;

public class CancellationDTO {

    private int idCancellation;
    private int idRecord;
    private Date dateTo;
    private Date dateFrom;
    private RecordDTO recordByIdRecord;

    public CancellationDTO(int idCancellation, int idRecord, Date dateTo, Date dateFrom, RecordDTO recordByIdRecord) {
        this.idCancellation = idCancellation;
        this.idRecord = idRecord;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
        this.recordByIdRecord = recordByIdRecord;
    }

    public CancellationDTO() {
    }

    public int getIdCancellation() {
        return idCancellation;
    }

    public void setIdCancellation(int idCancellation) {
        this.idCancellation = idCancellation;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public RecordDTO getRecordByIdRecord() {
        return recordByIdRecord;
    }

    public void setRecordByIdRecord(RecordDTO recordByIdRecord) {
        this.recordByIdRecord = recordByIdRecord;
    }
}
