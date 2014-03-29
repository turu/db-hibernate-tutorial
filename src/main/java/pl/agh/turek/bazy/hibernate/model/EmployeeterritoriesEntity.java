package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Piotr Turek
 */
@javax.persistence.IdClass(pl.agh.turek.bazy.hibernate.model.EmployeeterritoriesEntityPK.class)
@javax.persistence.Table(name = "employeeterritories", schema = "public", catalog = "northwind")
@Entity
public class EmployeeterritoriesEntity {
    private short employeeId;

    @javax.persistence.Column(name = "EmployeeID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Id
    public short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(short employeeId) {
        this.employeeId = employeeId;
    }

    private String territoryId;

    @javax.persistence.Column(name = "TerritoryID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
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

        EmployeeterritoriesEntity that = (EmployeeterritoriesEntity) o;

        if (employeeId != that.employeeId) return false;
        if (territoryId != null ? !territoryId.equals(that.territoryId) : that.territoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) employeeId;
        result = 31 * result + (territoryId != null ? territoryId.hashCode() : 0);
        return result;
    }
}
