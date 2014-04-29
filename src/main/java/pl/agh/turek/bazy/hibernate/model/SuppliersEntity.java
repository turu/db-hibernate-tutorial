package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "suppliers", schema = "public", catalog = "northwind")
public class SuppliersEntity {
    private long supplierid;
    private String companyname;
    private String contactname;
    private String contacttitle;
    private String address;
    private String city;
    private String region;
    private String postalcode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;
    private Collection<ProductsEntity> productsesBySupplierid;

    @Id
    @Column(name = "supplierid", nullable = false, insertable = true, updatable = true)
    public long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(long supplierid) {
        this.supplierid = supplierid;
    }

    @Basic
    @Column(name = "companyname", nullable = false, insertable = true, updatable = true, length = 40)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Basic
    @Column(name = "contactname", nullable = true, insertable = true, updatable = true, length = 30)
    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    @Basic
    @Column(name = "contacttitle", nullable = true, insertable = true, updatable = true, length = 30)
    public String getContacttitle() {
        return contacttitle;
    }

    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
    }

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 60)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, insertable = true, updatable = true, length = 15)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region", nullable = true, insertable = true, updatable = true, length = 15)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "postalcode", nullable = true, insertable = true, updatable = true, length = 10)
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "country", nullable = true, insertable = true, updatable = true, length = 15)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 24)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax", nullable = true, insertable = true, updatable = true, length = 24)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "homepage", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuppliersEntity that = (SuppliersEntity) o;

        if (supplierid != that.supplierid) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (companyname != null ? !companyname.equals(that.companyname) : that.companyname != null) return false;
        if (contactname != null ? !contactname.equals(that.contactname) : that.contactname != null) return false;
        if (contacttitle != null ? !contacttitle.equals(that.contacttitle) : that.contacttitle != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (supplierid ^ (supplierid >>> 32));
        result = 31 * result + (companyname != null ? companyname.hashCode() : 0);
        result = 31 * result + (contactname != null ? contactname.hashCode() : 0);
        result = 31 * result + (contacttitle != null ? contacttitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "suppliersBySupplierid")
    public Collection<ProductsEntity> getProductsesBySupplierid() {
        return productsesBySupplierid;
    }

    public void setProductsesBySupplierid(Collection<ProductsEntity> productsesBySupplierid) {
        this.productsesBySupplierid = productsesBySupplierid;
    }
}
