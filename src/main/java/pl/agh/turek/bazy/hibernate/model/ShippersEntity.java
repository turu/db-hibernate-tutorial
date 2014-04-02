package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "shippers", schema = "public", catalog = "northwind")
@Entity
public class ShippersEntity {
    private short shipperId;

    @javax.persistence.Column(name = "ShipperID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Id
    public short getShipperId() {
        return shipperId;
    }

    public void setShipperId(short shipperId) {
        this.shipperId = shipperId;
    }

    private String companyName;

    @javax.persistence.Column(name = "CompanyName", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String phone;

    @javax.persistence.Column(name = "Phone", nullable = true, insertable = true, updatable = true, length = 24, precision = 0)
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippersEntity that = (ShippersEntity) o;

        if (shipperId != that.shipperId) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) shipperId;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
