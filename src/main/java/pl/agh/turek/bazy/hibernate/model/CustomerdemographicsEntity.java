package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "customerdemographics", schema = "public", catalog = "northwind")
@Entity
public class CustomerdemographicsEntity {
    private String customerTypeId;

    @javax.persistence.Column(name = "CustomerTypeID", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Id
    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    private String customerDesc;

    @javax.persistence.Column(name = "CustomerDesc", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerdemographicsEntity that = (CustomerdemographicsEntity) o;

        if (customerDesc != null ? !customerDesc.equals(that.customerDesc) : that.customerDesc != null) return false;
        if (customerTypeId != null ? !customerTypeId.equals(that.customerTypeId) : that.customerTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerTypeId != null ? customerTypeId.hashCode() : 0;
        result = 31 * result + (customerDesc != null ? customerDesc.hashCode() : 0);
        return result;
    }
}
