package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Piotr Turek
 */
@javax.persistence.Table(name = "products", schema = "public", catalog = "northwind")
@Entity
public class ProductsEntity {
    private short productId;

    @javax.persistence.Column(name = "ProductID", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Id
    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }

    private String productName;

    @javax.persistence.Column(name = "ProductName", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private Short supplierId;

    @javax.persistence.Column(name = "SupplierID", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Short supplierId) {
        this.supplierId = supplierId;
    }

    private Short categoryId;

    @javax.persistence.Column(name = "CategoryID", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    private String quantityPerUnit;

    @javax.persistence.Column(name = "QuantityPerUnit", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    private Float unitPrice;

    @javax.persistence.Column(name = "UnitPrice", nullable = true, insertable = true, updatable = true, length = 8, precision = 8)
    @Basic
    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    private Short unitsInStock;

    @javax.persistence.Column(name = "UnitsInStock", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    private Short unitsOnOrder;

    @javax.persistence.Column(name = "UnitsOnOrder", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Short unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    private Short reorderLevel;

    @javax.persistence.Column(name = "ReorderLevel", nullable = true, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public Short getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Short reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    private int discontinued;

    @javax.persistence.Column(name = "Discontinued", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(int discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (discontinued != that.discontinued) return false;
        if (productId != that.productId) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (quantityPerUnit != null ? !quantityPerUnit.equals(that.quantityPerUnit) : that.quantityPerUnit != null)
            return false;
        if (reorderLevel != null ? !reorderLevel.equals(that.reorderLevel) : that.reorderLevel != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (unitsInStock != null ? !unitsInStock.equals(that.unitsInStock) : that.unitsInStock != null) return false;
        if (unitsOnOrder != null ? !unitsOnOrder.equals(that.unitsOnOrder) : that.unitsOnOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (quantityPerUnit != null ? quantityPerUnit.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (unitsInStock != null ? unitsInStock.hashCode() : 0);
        result = 31 * result + (unitsOnOrder != null ? unitsOnOrder.hashCode() : 0);
        result = 31 * result + (reorderLevel != null ? reorderLevel.hashCode() : 0);
        result = 31 * result + discontinued;
        return result;
    }
}
