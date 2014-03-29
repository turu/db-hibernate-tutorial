package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Entity;

/**
 * Author: Piotr Turek
 */
@javax.persistence.IdClass(pl.agh.turek.bazy.hibernate.model.OrderDetailsEntityPK.class)
@javax.persistence.Table(name = "order_details", schema = "public", catalog = "northwind")
@Entity
public class OrderDetailsEntity {
    private short orderId;

    @javax.persistence.Column(name = "OrderID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Id
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    private short productId;

    @javax.persistence.Column(name = "ProductID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Id
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }

    private float unitPrice;

    @javax.persistence.Column(name = "UnitPrice", nullable = false, insertable = true, updatable = true, length = 8, precision = 8)
    @javax.persistence.Basic
    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    private short quantity;

    @javax.persistence.Column(name = "Quantity", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Basic
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    private float discount;

    @javax.persistence.Column(name = "Discount", nullable = false, insertable = true, updatable = true, length = 8, precision = 8)
    @javax.persistence.Basic
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsEntity that = (OrderDetailsEntity) o;

        if (Float.compare(that.discount, discount) != 0) return false;
        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (Float.compare(that.unitPrice, unitPrice) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (int) productId;
        result = 31 * result + (unitPrice != +0.0f ? Float.floatToIntBits(unitPrice) : 0);
        result = 31 * result + (int) quantity;
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }
}
