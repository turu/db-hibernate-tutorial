package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "usstates", schema = "public", catalog = "northwind")
@Entity
public class UsstatesEntity {
    private short stateId;

    @javax.persistence.Column(name = "StateID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStateId() {
        return stateId;
    }

    public void setStateId(short stateId) {
        this.stateId = stateId;
    }

    private String stateName;

    @javax.persistence.Column(name = "StateName", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    private String stateAbbr;

    @javax.persistence.Column(name = "StateAbbr", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    private String stateRegion;

    @javax.persistence.Column(name = "StateRegion", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateRegion) {
        this.stateRegion = stateRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsstatesEntity that = (UsstatesEntity) o;

        if (stateId != that.stateId) return false;
        if (stateAbbr != null ? !stateAbbr.equals(that.stateAbbr) : that.stateAbbr != null) return false;
        if (stateName != null ? !stateName.equals(that.stateName) : that.stateName != null) return false;
        if (stateRegion != null ? !stateRegion.equals(that.stateRegion) : that.stateRegion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) stateId;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        result = 31 * result + (stateAbbr != null ? stateAbbr.hashCode() : 0);
        result = 31 * result + (stateRegion != null ? stateRegion.hashCode() : 0);
        return result;
    }
}
