package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Entity;

/**
 * Author: Piotr Turek
 */
@javax.persistence.IdClass(pl.agh.turek.bazy.hibernate.model.CustomercustomerdemoEntityPK.class)
@javax.persistence.Table(name = "customercustomerdemo", schema = "public", catalog = "northwind")
@Entity
public class CustomercustomerdemoEntity {
    private String customerId;

    @javax.persistence.Column(name = "CustomerID", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Id
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private String customerTypeId;

    @javax.persistence.Column(name = "CustomerTypeID", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Id
    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomercustomerdemoEntity that = (CustomercustomerdemoEntity) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (customerTypeId != null ? !customerTypeId.equals(that.customerTypeId) : that.customerTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (customerTypeId != null ? customerTypeId.hashCode() : 0);
        return result;
    }
}
