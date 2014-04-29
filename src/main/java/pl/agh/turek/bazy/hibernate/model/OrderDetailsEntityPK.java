package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Piotr Turek
 */
public class OrderDetailsEntityPK implements Serializable {
    private long orderid;
    private long productid;

    @Column(name = "orderid", nullable = false, insertable = true, updatable = true)
    @Id
    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    @Column(name = "productid", nullable = false, insertable = true, updatable = true)
    @Id
    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsEntityPK that = (OrderDetailsEntityPK) o;

        if (orderid != that.orderid) return false;
        if (productid != that.productid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderid ^ (orderid >>> 32));
        result = 31 * result + (int) (productid ^ (productid >>> 32));
        return result;
    }
}
