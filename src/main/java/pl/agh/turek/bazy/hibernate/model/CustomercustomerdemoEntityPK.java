package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Piotr Turek
 */
public class CustomercustomerdemoEntityPK implements Serializable {
    private String customerId;
    private String customerTypeId;

@Id@Column(name = "CustomerID", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
public String getCustomerId() {
    return customerId;
}

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Id@Column(name = "CustomerTypeID", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
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

        CustomercustomerdemoEntityPK that = (CustomercustomerdemoEntityPK) o;

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
}}
