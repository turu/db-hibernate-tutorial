package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Piotr Turek
 */
public class EmployeeterritoriesEntityPK implements Serializable {
    private long employeeid;
    private String territoryid;

    @Column(name = "employeeid", nullable = false, insertable = false, updatable = false)
    @Id
    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    @Column(name = "territoryid", nullable = false, insertable = false, updatable = false, length = 20)
    @Id
    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeterritoriesEntityPK that = (EmployeeterritoriesEntityPK) o;

        if (employeeid != that.employeeid) return false;
        if (territoryid != null ? !territoryid.equals(that.territoryid) : that.territoryid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeid ^ (employeeid >>> 32));
        result = 31 * result + (territoryid != null ? territoryid.hashCode() : 0);
        return result;
    }
}
