package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "orders", schema = "public", catalog = "northwind")
@Entity
public class OrdersEntity {
    private short orderId;

    @javax.persistence.Column(name = "OrderID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Id
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    private String customerId;

    @javax.persistence.Column(name = "CustomerID", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private Short employeeId;

    @javax.persistence.Column(name = "EmployeeID", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Short employeeId) {
        this.employeeId = employeeId;
    }

    private Date orderDate;

    @javax.persistence.Column(name = "OrderDate", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    @Basic
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    private Date requiredDate;

    @javax.persistence.Column(name = "RequiredDate", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    @Basic
    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    private Date shippedDate;

    @javax.persistence.Column(name = "ShippedDate", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    @Basic
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    private Short shipVia;

    @javax.persistence.Column(name = "ShipVia", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getShipVia() {
        return shipVia;
    }

    public void setShipVia(Short shipVia) {
        this.shipVia = shipVia;
    }

    private Float freight;

    @javax.persistence.Column(name = "Freight", nullable = true, insertable = true, updatable = true, length = 8, precision = 8)
    @Basic
    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    private String shipName;

    @javax.persistence.Column(name = "ShipName", nullable = true, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    private String shipAddress;

    @javax.persistence.Column(name = "ShipAddress", nullable = true, insertable = true, updatable = true, length = 60, precision = 0)
    @Basic
    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    private String shipCity;

    @javax.persistence.Column(name = "ShipCity", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    private String shipRegion;

    @javax.persistence.Column(name = "ShipRegion", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    private String shipPostalCode;

    @javax.persistence.Column(name = "ShipPostalCode", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    private String shipCountry;

    @javax.persistence.Column(name = "ShipCountry", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (freight != null ? !freight.equals(that.freight) : that.freight != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (requiredDate != null ? !requiredDate.equals(that.requiredDate) : that.requiredDate != null) return false;
        if (shipAddress != null ? !shipAddress.equals(that.shipAddress) : that.shipAddress != null) return false;
        if (shipCity != null ? !shipCity.equals(that.shipCity) : that.shipCity != null) return false;
        if (shipCountry != null ? !shipCountry.equals(that.shipCountry) : that.shipCountry != null) return false;
        if (shipName != null ? !shipName.equals(that.shipName) : that.shipName != null) return false;
        if (shipPostalCode != null ? !shipPostalCode.equals(that.shipPostalCode) : that.shipPostalCode != null)
            return false;
        if (shipRegion != null ? !shipRegion.equals(that.shipRegion) : that.shipRegion != null) return false;
        if (shipVia != null ? !shipVia.equals(that.shipVia) : that.shipVia != null) return false;
        if (shippedDate != null ? !shippedDate.equals(that.shippedDate) : that.shippedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + (shipVia != null ? shipVia.hashCode() : 0);
        result = 31 * result + (freight != null ? freight.hashCode() : 0);
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        result = 31 * result + (shipAddress != null ? shipAddress.hashCode() : 0);
        result = 31 * result + (shipCity != null ? shipCity.hashCode() : 0);
        result = 31 * result + (shipRegion != null ? shipRegion.hashCode() : 0);
        result = 31 * result + (shipPostalCode != null ? shipPostalCode.hashCode() : 0);
        result = 31 * result + (shipCountry != null ? shipCountry.hashCode() : 0);
        return result;
    }
}
