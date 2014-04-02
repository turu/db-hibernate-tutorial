package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Entity;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "territories", schema = "public", catalog = "northwind")
@Entity
public class TerritoriesEntity {
    private String territoryId;

    @javax.persistence.Column(name = "TerritoryID", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @javax.persistence.Id
    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    private String territoryDescription;

    @javax.persistence.Column(name = "TerritoryDescription", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Basic
    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    private short regionId;

    @javax.persistence.Column(name = "RegionID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Basic
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
