package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Cancellation {
    private int idCancellation;
    private int idRecord;
    private Date dateTo;
    private Date dateFrom;
    private Record recordByIdRecord;

    @Id
    @Column(name = "id_cancellation", nullable = false)
    public int getIdCancellation() {
        return idCancellation;
    }

    public void setIdCancellation(int idCancellation) {
        this.idCancellation = idCancellation;
    }

    @Basic
    @Column(name = "id_record", nullable = false)
    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    @Basic
    @Column(name = "date_to", nullable = false)
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Basic
    @Column(name = "date_from", nullable = false)
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancellation that = (Cancellation) o;
        return idCancellation == that.idCancellation &&
                idRecord == that.idRecord &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(dateFrom, that.dateFrom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCancellation, idRecord, dateTo, dateFrom);
    }

    @ManyToOne
    @JoinColumn(name = "id_record", referencedColumnName = "id_record", nullable = false)
    public Record getRecordByIdRecord() {
        return recordByIdRecord;
    }

    public void setRecordByIdRecord(Record recordByIdRecord) {
        this.recordByIdRecord = recordByIdRecord;
    }
}
