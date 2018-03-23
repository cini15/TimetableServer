package by.bsac.server.api.date.dto;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancellationDTO {

    private int idCancellation;
    private int idRecord;
    private Date dateTo;
    private Date dateFrom;

    public CancellationDTO(int idCancellation, int idRecord, Date dateTo, Date dateFrom) {
        this.idCancellation = idCancellation;
        this.idRecord = idRecord;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;

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

}
