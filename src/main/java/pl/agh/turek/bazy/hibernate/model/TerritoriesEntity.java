package pl.agh.turek.bazy.hibernate.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "territories", schema = "public", catalog = "northwind")
public class TerritoriesEntity {
    private String territoryid;
    private String territorydescription;
    private Long regionid;
    private Collection<EmployeeterritoriesEntity> employeeterritoriesesByTerritoryid;
    private RegionEntity regionByRegionid;

    @Id
    @Column(name = "territoryid", nullable = false, insertable = true, updatable = true, length = 20)
    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    @Basic
    @Column(name = "territorydescription", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTerritorydescription() {
        return territorydescription;
    }

    public void setTerritorydescription(String territorydescription) {
        this.territorydescription = territorydescription;
    }

    @Basic
    @Column(name = "regionid", insertable = false, updatable = false)
    public Long getRegionid() {
        return regionid;
    }

    public void setRegionid(Long regionid) {
        this.regionid = regionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerritoriesEntity that = (TerritoriesEntity) o;

        if (regionid != that.regionid) return false;
        if (territorydescription != null ? !territorydescription.equals(that.territorydescription) : that.territorydescription != null)
            return false;
        if (territoryid != null ? !territoryid.equals(that.territoryid) : that.territoryid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = territoryid != null ? territoryid.hashCode() : 0;
        result = 31 * result + (territorydescription != null ? territorydescription.hashCode() : 0);
        result = 31 * result + (int) (regionid ^ (regionid >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "territoriesByTerritoryid")
    public Collection<EmployeeterritoriesEntity> getEmployeeterritoriesesByTerritoryid() {
        return employeeterritoriesesByTerritoryid;
    }

    public void setEmployeeterritoriesesByTerritoryid(Collection<EmployeeterritoriesEntity> employeeterritoriesesByTerritoryid) {
        this.employeeterritoriesesByTerritoryid = employeeterritoriesesByTerritoryid;
    }

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "regionid", referencedColumnName = "regionid")
    public RegionEntity getRegionByRegionid() {
        return regionByRegionid;
    }

    public void setRegionByRegionid(RegionEntity regionByRegionid) {
        this.regionByRegionid = regionByRegionid;
    }
}
