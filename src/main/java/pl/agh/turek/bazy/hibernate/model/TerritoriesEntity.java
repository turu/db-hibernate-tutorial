package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "territories")
public class TerritoriesEntity {
    private String territoryId;

    @Id
    @Column(name = "TerritoryID", nullable = false, length = 20)
    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    private String territoryDescription;

    @Column(name = "TerritoryDescription", nullable = false)
    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    private short regionId;

    @Column(name = "RegionID")
    public short getRegionId() {
        return regionId;
    }

    public void setRegionId(short regionId) {
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerritoriesEntity that = (TerritoriesEntity) o;

        if (regionId != that.regionId) return false;
        if (territoryDescription != null ? !territoryDescription.equals(that.territoryDescription) : that.territoryDescription != null)
            return false;
        if (territoryId != null ? !territoryId.equals(that.territoryId) : that.territoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = territoryId != null ? territoryId.hashCode() : 0;
        result = 31 * result + (territoryDescription != null ? territoryDescription.hashCode() : 0);
        result = 31 * result + (int) regionId;
        return result;
    }
}
