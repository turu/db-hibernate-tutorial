package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Entity;
import java.sql.Date;
import java.util.Arrays;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "employees", schema = "public", catalog = "northwind")
@Entity
public class EmployeesEntity {
    private short employeeId;

    @javax.persistence.Column(name = "EmployeeID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Id
    public short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(short employeeId) {
        this.employeeId = employeeId;
    }

    private String lastName;

    @javax.persistence.Column(name = "LastName", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @javax.persistence.Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;

    @javax.persistence.Column(name = "FirstName", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @javax.persistence.Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String title;

    @javax.persistence.Column(name = "Title", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    @javax.persistence.Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String titleOfCourtesy;

    @javax.persistence.Column(name = "TitleOfCourtesy", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @javax.persistence.Basic
    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    private Date birthDate;

    @javax.persistence.Column(name = "BirthDate", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    @javax.persistence.Basic
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Date hireDate;

    @javax.persistence.Column(name = "HireDate", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    @javax.persistence.Basic
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    private String address;

    @javax.persistence.Column(name = "Address", nullable = true, insertable = true, updatable = true, length = 60, precision = 0)
    @javax.persistence.Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String city;

    @javax.persistence.Column(name = "City", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @javax.persistence.Basic
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String region;

    @javax.persistence.Column(name = "Region", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @javax.persistence.Basic
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    private String postalCode;

    @javax.persistence.Column(name = "PostalCode", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @javax.persistence.Basic
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String country;

    @javax.persistence.Column(name = "Country", nullable = true, insertable = true, updatable = true, length = 15, precision = 0)
    @javax.persistence.Basic
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String homePhone;

    @javax.persistence.Column(name = "HomePhone", nullable = true, insertable = true, updatable = true, length = 24, precision = 0)
    @javax.persistence.Basic
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    private String extension;

    @javax.persistence.Column(name = "Extension", nullable = true, insertable = true, updatable = true, length = 4, precision = 0)
    @javax.persistence.Basic
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    private byte[] photo;

    @javax.persistence.Column(name = "Photo", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Basic
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    private String notes;

    @javax.persistence.Column(name = "Notes", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private Short reportsTo;

    @javax.persistence.Column(name = "ReportsTo", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Basic
    public Short getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Short reportsTo) {
        this.reportsTo = reportsTo;
    }

    private String photoPath;

    @javax.persistence.Column(name = "PhotoPath", nullable = true, insertable = true, updatable = true, length = 255, precision = 0)
    @javax.persistence.Basic
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesEntity that = (EmployeesEntity) o;

        if (employeeId != that.employeeId) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;
        if (photoPath != null ? !photoPath.equals(that.photoPath) : that.photoPath != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (reportsTo != null ? !reportsTo.equals(that.reportsTo) : that.reportsTo != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (titleOfCourtesy != null ? !titleOfCourtesy.equals(that.titleOfCourtesy) : that.titleOfCourtesy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) employeeId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (titleOfCourtesy != null ? titleOfCourtesy.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (reportsTo != null ? reportsTo.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        return result;
    }
}
