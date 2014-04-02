package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "region", schema = "public", catalog = "northwind")
@Entity
public class RegionEntity {
    private short regionId;

    @javax.persistence.Column(name = "RegionID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Id
    public short getRegionId() {
        return regionId;
    }

    public void setRegionId(short regionId) {
        this.regionId = regionId;
    }

    private String regionDescription;

    @javax.persistence.Column(name = "RegionDescription", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (regionId != that.regionId) return false;
        if (regionDescription != null ? !regionDescription.equals(that.regionDescription) : that.regionDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) regionId;
        result = 31 * result + (regionDescription != null ? regionDescription.hashCode() : 0);
        return result;
    }
}
