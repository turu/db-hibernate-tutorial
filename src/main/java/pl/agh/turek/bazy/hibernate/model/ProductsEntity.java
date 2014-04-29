package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "products", schema = "public", catalog = "northwind")
public class ProductsEntity {
    private long productid;
    private String productname;
    private Long supplierid;
    private Long categoryid;
    private String quantityperunit;
    private Double unitprice;
    private Integer unitsinstock;
    private Integer unitsonorder;
    private Integer reorderlevel;
    private boolean discontinued;
    private Collection<OrderDetailsEntity> orderDetailsesByProductid;
    private CategoriesEntity categoriesByCategoryid;
    private SuppliersEntity suppliersBySupplierid;

    @Id
    @Column(name = "productid", nullable = false, insertable = true, updatable = true)
    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "productname", nullable = false, insertable = true, updatable = true, length = 40)
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Basic
    @Column(name = "supplierid", nullable = true, insertable = true, updatable = true)
    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

    @Basic
    @Column(name = "categoryid", nullable = true, insertable = true, updatable = true)
    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "quantityperunit", nullable = true, insertable = true, updatable = true, length = 20)
    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    @Basic
    @Column(name = "unitprice", nullable = true, insertable = true, updatable = true, precision = 17)
    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "unitsinstock", nullable = true, insertable = true, updatable = true)
    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    @Basic
    @Column(name = "unitsonorder", nullable = true, insertable = true, updatable = true)
    public Integer getUnitsonorder() {
        return unitsonorder;
    }

    public void setUnitsonorder(Integer unitsonorder) {
        this.unitsonorder = unitsonorder;
    }

    @Basic
    @Column(name = "reorderlevel", nullable = true, insertable = true, updatable = true)
    public Integer getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(Integer reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    @Basic
    @Column(name = "discontinued", nullable = false, insertable = true, updatable = true)
    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (discontinued != that.discontinued) return false;
        if (productid != that.productid) return false;
        if (categoryid != null ? !categoryid.equals(that.categoryid) : that.categoryid != null) return false;
        if (productname != null ? !productname.equals(that.productname) : that.productname != null) return false;
        if (quantityperunit != null ? !quantityperunit.equals(that.quantityperunit) : that.quantityperunit != null)
            return false;
        if (reorderlevel != null ? !reorderlevel.equals(that.reorderlevel) : that.reorderlevel != null) return false;
        if (supplierid != null ? !supplierid.equals(that.supplierid) : that.supplierid != null) return false;
        if (unitprice != null ? !unitprice.equals(that.unitprice) : that.unitprice != null) return false;
        if (unitsinstock != null ? !unitsinstock.equals(that.unitsinstock) : that.unitsinstock != null) return false;
        if (unitsonorder != null ? !unitsonorder.equals(that.unitsonorder) : that.unitsonorder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (productid ^ (productid >>> 32));
        result = 31 * result + (productname != null ? productname.hashCode() : 0);
        result = 31 * result + (supplierid != null ? supplierid.hashCode() : 0);
        result = 31 * result + (categoryid != null ? categoryid.hashCode() : 0);
        result = 31 * result + (quantityperunit != null ? quantityperunit.hashCode() : 0);
        result = 31 * result + (unitprice != null ? unitprice.hashCode() : 0);
        result = 31 * result + (unitsinstock != null ? unitsinstock.hashCode() : 0);
        result = 31 * result + (unitsonorder != null ? unitsonorder.hashCode() : 0);
        result = 31 * result + (reorderlevel != null ? reorderlevel.hashCode() : 0);
        result = 31 * result + (discontinued ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "productsByProductid")
    public Collection<OrderDetailsEntity> getOrderDetailsesByProductid() {
        return orderDetailsesByProductid;
    }

    public void setOrderDetailsesByProductid(Collection<OrderDetailsEntity> orderDetailsesByProductid) {
        this.orderDetailsesByProductid = orderDetailsesByProductid;
    }

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    public CategoriesEntity getCategoriesByCategoryid() {
        return categoriesByCategoryid;
    }

    public void setCategoriesByCategoryid(CategoriesEntity categoriesByCategoryid) {
        this.categoriesByCategoryid = categoriesByCategoryid;
    }

    @ManyToOne
    @JoinColumn(name = "supplierid", referencedColumnName = "supplierid")
    public SuppliersEntity getSuppliersBySupplierid() {
        return suppliersBySupplierid;
    }

    public void setSuppliersBySupplierid(SuppliersEntity suppliersBySupplierid) {
        this.suppliersBySupplierid = suppliersBySupplierid;
    }
}
