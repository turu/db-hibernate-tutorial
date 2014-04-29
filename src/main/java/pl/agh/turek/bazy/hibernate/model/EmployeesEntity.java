package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "employees", schema = "public", catalog = "northwind")
public class EmployeesEntity {
    private long employeeid;
    private String lastname;
    private String firstname;
    private String title;
    private String titleofcourtesy;
    private Date birthdate;
    private Date hiredate;
    private String address;
    private String city;
    private String region;
    private String postalcode;
    private String country;
    private String homephone;
    private String extension;
    private byte[] photo;
    private String notes;
    private Long reportsto;
    private String photopath;
    private EmployeesEntity employeesByReportsto;
    private Collection<EmployeesEntity> employeesesByEmployeeid;
    private Collection<EmployeeterritoriesEntity> employeeterritoriesesByEmployeeid;
    private Collection<OrdersEntity> ordersesByEmployeeid;

    @Id
    @Column(name = "employeeid", nullable = false, insertable = true, updatable = true)
    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "lastname", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, insertable = true, updatable = true, length = 10)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "titleofcourtesy", nullable = true, insertable = true, updatable = true, length = 25)
    public String getTitleofcourtesy() {
        return titleofcourtesy;
    }

    public void setTitleofcourtesy(String titleofcourtesy) {
        this.titleofcourtesy = titleofcourtesy;
    }

    @Basic
    @Column(name = "birthdate", nullable = true, insertable = true, updatable = true)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "hiredate", nullable = true, insertable = true, updatable = true)
    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
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
    @Column(name = "homephone", nullable = true, insertable = true, updatable = true, length = 24)
    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    @Basic
    @Column(name = "extension", nullable = true, insertable = true, updatable = true, length = 4)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "photo", nullable = true, insertable = true, updatable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "notes", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "reportsto", nullable = true, insertable = false, updatable = false)
    public Long getReportsto() {
        return reportsto;
    }

    public void setReportsto(Long reportsto) {
        this.reportsto = reportsto;
    }

    @Basic
    @Column(name = "photopath", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesEntity that = (EmployeesEntity) o;

        if (employeeid != that.employeeid) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (hiredate != null ? !hiredate.equals(that.hiredate) : that.hiredate != null) return false;
        if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;
        if (photopath != null ? !photopath.equals(that.photopath) : that.photopath != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (reportsto != null ? !reportsto.equals(that.reportsto) : that.reportsto != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (titleofcourtesy != null ? !titleofcourtesy.equals(that.titleofcourtesy) : that.titleofcourtesy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeid ^ (employeeid >>> 32));
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (titleofcourtesy != null ? titleofcourtesy.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (hiredate != null ? hiredate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (reportsto != null ? reportsto.hashCode() : 0);
        result = 31 * result + (photopath != null ? photopath.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "reportsto", referencedColumnName = "employeeid")
    public EmployeesEntity getEmployeesByReportsto() {
        return employeesByReportsto;
    }

    public void setEmployeesByReportsto(EmployeesEntity employeesByReportsto) {
        this.employeesByReportsto = employeesByReportsto;
    }

    @OneToMany(mappedBy = "employeesByReportsto")
    public Collection<EmployeesEntity> getEmployeesesByEmployeeid() {
        return employeesesByEmployeeid;
    }

    public void setEmployeesesByEmployeeid(Collection<EmployeesEntity> employeesesByEmployeeid) {
        this.employeesesByEmployeeid = employeesesByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<EmployeeterritoriesEntity> getEmployeeterritoriesesByEmployeeid() {
        return employeeterritoriesesByEmployeeid;
    }

    public void setEmployeeterritoriesesByEmployeeid(Collection<EmployeeterritoriesEntity> employeeterritoriesesByEmployeeid) {
        this.employeeterritoriesesByEmployeeid = employeeterritoriesesByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<OrdersEntity> getOrdersesByEmployeeid() {
        return ordersesByEmployeeid;
    }

    public void setOrdersesByEmployeeid(Collection<OrdersEntity> ordersesByEmployeeid) {
        this.ordersesByEmployeeid = ordersesByEmployeeid;
    }
}
