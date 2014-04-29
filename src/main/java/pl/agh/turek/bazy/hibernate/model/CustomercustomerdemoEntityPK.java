package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Piotr Turek
 */
public class CustomercustomerdemoEntityPK implements Serializable {
    private String customerid;
    private String customertypeid;

    @Column(name = "customerid", nullable = false, insertable = true, updatable = true, length = 5)
    @Id
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    @Column(name = "customertypeid", nullable = false, insertable = true, updatable = true, length = 10)
    @Id
    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomercustomerdemoEntityPK that = (CustomercustomerdemoEntityPK) o;

        if (customerid != null ? !customerid.equals(that.customerid) : that.customerid != null) return false;
        if (customertypeid != null ? !customertypeid.equals(that.customertypeid) : that.customertypeid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (customertypeid != null ? customertypeid.hashCode() : 0);
        return result;
    }
}
