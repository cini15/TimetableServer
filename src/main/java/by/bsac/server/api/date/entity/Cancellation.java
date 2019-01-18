package by.bsac.server.api.date.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cancellation",schema = "timetable")
public class Cancellation {
    private Integer idCancellation;
    private Integer idRecord;
    private Date dateTo;
    private Date dateFrom;
    private Record recordByIdRecord;

    @Id
    @Column(name = "id_cancellation", nullable = false)
    public Integer getIdCancellation() {
        return idCancellation;
    }

    public void setIdCancellation(Integer idCancellation) {
        this.idCancellation = idCancellation;
    }

    @Basic
    @Column(name = "id_record", nullable = false,insertable = false,updatable = false)
    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
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

        if (!idCancellation.equals(that.idCancellation)) return false;
        if (!idRecord.equals(that.idRecord)) return false;
        if (!dateTo.equals(that.dateTo)) return false;
        if (!dateFrom.equals(that.dateFrom)) return false;
        return recordByIdRecord.equals(that.recordByIdRecord);
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
