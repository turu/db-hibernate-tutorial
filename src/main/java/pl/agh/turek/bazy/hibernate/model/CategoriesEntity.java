package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Entity;
import java.util.Arrays;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "categories", schema = "public", catalog = "northwind")
@Entity
public class CategoriesEntity {
    private short categoryId;

    @javax.persistence.Column(name = "CategoryID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @javax.persistence.Id
    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    private String categoryName;

    @javax.persistence.Column(name = "CategoryName", nullable = false, insertable = true, updatable = true, length = 15, precision = 0)
    @javax.persistence.Basic
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private String description;

    @javax.persistence.Column(name = "Description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private byte[] picture;

    @javax.persistence.Column(name = "Picture", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @javax.persistence.Basic
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesEntity that = (CategoriesEntity) o;

        if (categoryId != that.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (picture != null ? Arrays.hashCode(picture) : 0);
        return result;
    }
}
