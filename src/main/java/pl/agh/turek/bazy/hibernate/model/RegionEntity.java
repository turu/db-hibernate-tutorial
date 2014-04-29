package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "region", schema = "public", catalog = "northwind")
public class RegionEntity {
    private long regionid;
    private String regiondescription;
    private Collection<TerritoriesEntity> territoriesesByRegionid;

    @Id
    @Column(name = "regionid", nullable = false, insertable = true, updatable = true)
    public long getRegionid() {
        return regionid;
    }

    public void setRegionid(long regionid) {
        this.regionid = regionid;
    }

    @Basic
    @Column(name = "regiondescription", nullable = false, insertable = true, updatable = true, length = 10000)
    public String getRegiondescription() {
        return regiondescription;
    }

    public void setRegiondescription(String regiondescription) {
        this.regiondescription = regiondescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (regionid != that.regionid) return false;
        if (regiondescription != null ? !regiondescription.equals(that.regiondescription) : that.regiondescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (regionid ^ (regionid >>> 32));
        result = 31 * result + (regiondescription != null ? regiondescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionByRegionid")
    public Collection<TerritoriesEntity> getTerritoriesesByRegionid() {
        return territoriesesByRegionid;
    }

    public void setTerritoriesesByRegionid(Collection<TerritoriesEntity> territoriesesByRegionid) {
        this.territoriesesByRegionid = territoriesesByRegionid;
    }
}
