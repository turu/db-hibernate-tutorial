package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "customers", schema = "public", catalog = "northwind")
@Entity
public class CustomersEntity {
    private String customerID;

    @javax.persistence.Column(name = "CustomerID", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Id
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerId) {
        this.customerID = customerId;
    }

    private String companyName;

    @javax.persistence.Column(name = "CompanyName", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String contactName;

    @javax.persistence.Column(name = "ContactName", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    @Basic
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    private String contactTitle;

    @javax.persistence.Column(name = "ContactTitle", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    @Basic
    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    private String address;

    @javax.persistence.Column(name = "Address", nullable = true, insertable = true, updatable = true, length = 60, precision = 0)
    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String city;

    @javax.persistence.Column(name = "City", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String region;

    @javax.persistence.Column(name = "Region", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    private String postalCode;

    @javax.persistence.Column(name = "PostalCode", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String country;

    @javax.persistence.Column(name = "Country", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @Basic
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String phone;

    @javax.persistence.Column(name = "Phone", nullable = true, insertable = true, updatable = true, length = 24, precision = 0)
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String fax;

    @javax.persistence.Column(name = "Fax", nullable = true, insertable = true, updatable = true, length = 24, precision = 0)
    @Basic
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (contactTitle != null ? !contactTitle.equals(that.contactTitle) : that.contactTitle != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (customerID != null ? !customerID.equals(that.customerID) : that.customerID != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerID != null ? customerID.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactTitle != null ? contactTitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        return result;
    }
}
