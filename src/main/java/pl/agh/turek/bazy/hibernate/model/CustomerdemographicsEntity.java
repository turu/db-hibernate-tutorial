package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "customerdemographics", schema = "public", catalog = "northwind")
public class CustomerdemographicsEntity {
    private String customertypeid;
    private String customerdesc;
    private Collection<CustomercustomerdemoEntity> customercustomerdemosByCustomertypeid;

    @Id
    @Column(name = "customertypeid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid;
    }

    @Basic
    @Column(name = "customerdesc", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getCustomerdesc() {
        return customerdesc;
    }

    public void setCustomerdesc(String customerdesc) {
        this.customerdesc = customerdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerdemographicsEntity that = (CustomerdemographicsEntity) o;

        if (customerdesc != null ? !customerdesc.equals(that.customerdesc) : that.customerdesc != null) return false;
        if (customertypeid != null ? !customertypeid.equals(that.customertypeid) : that.customertypeid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customertypeid != null ? customertypeid.hashCode() : 0;
        result = 31 * result + (customerdesc != null ? customerdesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerdemographicsByCustomertypeid")
    public Collection<CustomercustomerdemoEntity> getCustomercustomerdemosByCustomertypeid() {
        return customercustomerdemosByCustomertypeid;
    }

    public void setCustomercustomerdemosByCustomertypeid(Collection<CustomercustomerdemoEntity> customercustomerdemosByCustomertypeid) {
        this.customercustomerdemosByCustomertypeid = customercustomerdemosByCustomertypeid;
    }
}
