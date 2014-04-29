package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "categories", schema = "public", catalog = "northwind")
public class CategoriesEntity {
    private long categoryid;
    private String categoryname;
    private String description;
    private byte[] picture;
    private Collection<ProductsEntity> productsesByCategoryid;

    @Id
    @Column(name = "categoryid", nullable = false, insertable = true, updatable = true)
    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "categoryname", nullable = false, insertable = true, updatable = true, length = 15)
    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "picture", nullable = true, insertable = true, updatable = true)
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

        if (categoryid != that.categoryid) return false;
        if (categoryname != null ? !categoryname.equals(that.categoryname) : that.categoryname != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (categoryid ^ (categoryid >>> 32));
        result = 31 * result + (categoryname != null ? categoryname.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (picture != null ? Arrays.hashCode(picture) : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriesByCategoryid")
    public Collection<ProductsEntity> getProductsesByCategoryid() {
        return productsesByCategoryid;
    }

    public void setProductsesByCategoryid(Collection<ProductsEntity> productsesByCategoryid) {
        this.productsesByCategoryid = productsesByCategoryid;
    }
}
