package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "customercustomerdemo", schema = "public", catalog = "northwind")
@IdClass(CustomercustomerdemoEntityPK.class)
public class CustomercustomerdemoEntity {
    private String customerid;
    private String customertypeid;
    private CustomerdemographicsEntity customerdemographicsByCustomertypeid;
    private CustomersEntity customersByCustomerid;

    @Id
    @Column(name = "customerid", nullable = false, insertable = true, updatable = true, length = 5)
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    @Id
    @Column(name = "customertypeid", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomercustomerdemoEntity that = (CustomercustomerdemoEntity) o;

        if (customerid != null ? !customerid.equals(that.customerid) : that.customerid != null) return false;
        if (customertypeid != null ? !customertypeid.equals(that.customertypeid) : that.customertypeid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (customertypeid != null ? customertypeid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customertypeid", referencedColumnName = "customertypeid", nullable = false)
    public CustomerdemographicsEntity getCustomerdemographicsByCustomertypeid() {
        return customerdemographicsByCustomertypeid;
    }

    public void setCustomerdemographicsByCustomertypeid(CustomerdemographicsEntity customerdemographicsByCustomertypeid) {
        this.customerdemographicsByCustomertypeid = customerdemographicsByCustomertypeid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid", nullable = false)
    public CustomersEntity getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(CustomersEntity customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }
}
