package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Piotr Turek
 */
public class EmployeeterritoriesEntityPK implements Serializable {
    private short employeeId;
    private String territoryId;

@Id@Column(name = "EmployeeID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
public short getEmployeeId() {
    return employeeId;
}

    public void setEmployeeId(short employeeId) {
        this.employeeId = employeeId;
    }

    @Id@Column(name = "TerritoryID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeterritoriesEntityPK that = (EmployeeterritoriesEntityPK) o;

        if (employeeId != that.employeeId) return false;
        if (territoryId != null ? !territoryId.equals(that.territoryId) : that.territoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) employeeId;
        result = 31 * result + (territoryId != null ? territoryId.hashCode() : 0);
        return result;
}}
