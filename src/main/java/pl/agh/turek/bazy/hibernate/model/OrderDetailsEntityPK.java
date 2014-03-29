package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Piotr Turek
 */
public class OrderDetailsEntityPK implements Serializable {
    private short orderId;
    private short productId;

@Id@Column(name = "OrderID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
public short getOrderId() {
    return orderId;
}

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    @Id@Column(name = "ProductID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsEntityPK that = (OrderDetailsEntityPK) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (int) productId;
        return result;
}}
