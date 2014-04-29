package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "shippers", schema = "public", catalog = "northwind")
public class ShippersEntity {
    private long shipperid;
    private String companyname;
    private String phone;
    private Collection<OrdersEntity> ordersesByShipperid;

    @Id
    @Column(name = "shipperid", nullable = false, insertable = true, updatable = true)
    public long getShipperid() {
        return shipperid;
    }

    public void setShipperid(long shipperid) {
        this.shipperid = shipperid;
    }

    @Basic
    @Column(name = "companyname", nullable = false, insertable = true, updatable = true, length = 40)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 24)
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

        if (shipperid != that.shipperid) return false;
        if (companyname != null ? !companyname.equals(that.companyname) : that.companyname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (shipperid ^ (shipperid >>> 32));
        result = 31 * result + (companyname != null ? companyname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shippersByShipvia")
    public Collection<OrdersEntity> getOrdersesByShipperid() {
        return ordersesByShipperid;
    }

    public void setOrdersesByShipperid(Collection<OrdersEntity> ordersesByShipperid) {
        this.ordersesByShipperid = ordersesByShipperid;
    }
}
