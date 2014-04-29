package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "employeeterritories", schema = "public", catalog = "northwind")
@IdClass(EmployeeterritoriesEntityPK.class)
public class EmployeeterritoriesEntity {
    private long employeeid;
    private String territoryid;
    private EmployeesEntity employeesByEmployeeid;
    private TerritoriesEntity territoriesByTerritoryid;

    @Id
    @Column(name = "employeeid", nullable = false, insertable = true, updatable = true)
    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    @Id
    @Column(name = "territoryid", nullable = false, insertable = true, updatable = true, length = 20)
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

        EmployeeterritoriesEntity that = (EmployeeterritoriesEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid", nullable = false)
    public EmployeesEntity getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(EmployeesEntity employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }

    @ManyToOne
    @JoinColumn(name = "territoryid", referencedColumnName = "territoryid", nullable = false)
    public TerritoriesEntity getTerritoriesByTerritoryid() {
        return territoriesByTerritoryid;
    }

    public void setTerritoriesByTerritoryid(TerritoriesEntity territoriesByTerritoryid) {
        this.territoriesByTerritoryid = territoriesByTerritoryid;
    }
}
