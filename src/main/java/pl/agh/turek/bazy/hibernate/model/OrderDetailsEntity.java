package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "order_details", schema = "public", catalog = "northwind")
@IdClass(OrderDetailsEntityPK.class)
public class OrderDetailsEntity {
    private long orderid;
    private long productid;
    private double unitprice;
    private int quantity;
    private double discount;
    private OrdersEntity ordersByOrderid;
    private ProductsEntity productsByProductid;

    @Id
    @Column(name = "orderid", nullable = false, insertable = true, updatable = true)
    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    @Id
    @Column(name = "productid", nullable = false, insertable = true, updatable = true)
    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "unitprice", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "quantity", nullable = false, insertable = true, updatable = true)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "discount", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsEntity that = (OrderDetailsEntity) o;

        if (Double.compare(that.discount, discount) != 0) return false;
        if (orderid != that.orderid) return false;
        if (productid != that.productid) return false;
        if (quantity != that.quantity) return false;
        if (Double.compare(that.unitprice, unitprice) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (orderid ^ (orderid >>> 32));
        result = 31 * result + (int) (productid ^ (productid >>> 32));
        temp = Double.doubleToLongBits(unitprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", nullable = false)
    public OrdersEntity getOrdersByOrderid() {
        return ordersByOrderid;
    }

    public void setOrdersByOrderid(OrdersEntity ordersByOrderid) {
        this.ordersByOrderid = ordersByOrderid;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
    public ProductsEntity getProductsByProductid() {
        return productsByProductid;
    }

    public void setProductsByProductid(ProductsEntity productsByProductid) {
        this.productsByProductid = productsByProductid;
    }
}
