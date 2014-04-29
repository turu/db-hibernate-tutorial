package pl.agh.turek.bazy.hibernate.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "northwind")
public class OrdersEntity {
    private long orderid;
    private String customerid;
    private Long employeeid;
    private Date orderdate;
    private Date requireddate;
    private Date shippeddate;
    private Long shipvia;
    private Double freight;
    private String shipname;
    private String shipaddress;
    private String shipcity;
    private String shipregion;
    private String shippostalcode;
    private String shipcountry;
    private Collection<OrderDetailsEntity> orderDetailsesByOrderid;
    private CustomersEntity customersByCustomerid;
    private EmployeesEntity employeesByEmployeeid;
    private ShippersEntity shippersByShipvia;

    @Id
    @Column(name = "orderid", nullable = false, insertable = true, updatable = true)
    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "customerid", nullable = true, insertable = true, updatable = true, length = 5)
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "employeeid", nullable = true, insertable = true, updatable = true)
    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "orderdate", nullable = true, insertable = true, updatable = true)
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "requireddate", nullable = true, insertable = true, updatable = true)
    public Date getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    @Basic
    @Column(name = "shippeddate", nullable = true, insertable = true, updatable = true)
    public Date getShippeddate() {
        return shippeddate;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    @Basic
    @Column(name = "shipvia", nullable = true, insertable = true, updatable = true)
    public Long getShipvia() {
        return shipvia;
    }

    public void setShipvia(Long shipvia) {
        this.shipvia = shipvia;
    }

    @Basic
    @Column(name = "freight", nullable = true, insertable = true, updatable = true, precision = 17)
    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "shipname", nullable = true, insertable = true, updatable = true, length = 40)
    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    @Basic
    @Column(name = "shipaddress", nullable = true, insertable = true, updatable = true, length = 60)
    public String getShipaddress() {
        return shipaddress;
    }

    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress;
    }

    @Basic
    @Column(name = "shipcity", nullable = true, insertable = true, updatable = true, length = 15)
    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    @Basic
    @Column(name = "shipregion", nullable = true, insertable = true, updatable = true, length = 15)
    public String getShipregion() {
        return shipregion;
    }

    public void setShipregion(String shipregion) {
        this.shipregion = shipregion;
    }

    @Basic
    @Column(name = "shippostalcode", nullable = true, insertable = true, updatable = true, length = 10)
    public String getShippostalcode() {
        return shippostalcode;
    }

    public void setShippostalcode(String shippostalcode) {
        this.shippostalcode = shippostalcode;
    }

    @Basic
    @Column(name = "shipcountry", nullable = true, insertable = true, updatable = true, length = 15)
    public String getShipcountry() {
        return shipcountry;
    }

    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderid != that.orderid) return false;
        if (customerid != null ? !customerid.equals(that.customerid) : that.customerid != null) return false;
        if (employeeid != null ? !employeeid.equals(that.employeeid) : that.employeeid != null) return false;
        if (freight != null ? !freight.equals(that.freight) : that.freight != null) return false;
        if (orderdate != null ? !orderdate.equals(that.orderdate) : that.orderdate != null) return false;
        if (requireddate != null ? !requireddate.equals(that.requireddate) : that.requireddate != null) return false;
        if (shipaddress != null ? !shipaddress.equals(that.shipaddress) : that.shipaddress != null) return false;
        if (shipcity != null ? !shipcity.equals(that.shipcity) : that.shipcity != null) return false;
        if (shipcountry != null ? !shipcountry.equals(that.shipcountry) : that.shipcountry != null) return false;
        if (shipname != null ? !shipname.equals(that.shipname) : that.shipname != null) return false;
        if (shippeddate != null ? !shippeddate.equals(that.shippeddate) : that.shippeddate != null) return false;
        if (shippostalcode != null ? !shippostalcode.equals(that.shippostalcode) : that.shippostalcode != null)
            return false;
        if (shipregion != null ? !shipregion.equals(that.shipregion) : that.shipregion != null) return false;
        if (shipvia != null ? !shipvia.equals(that.shipvia) : that.shipvia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderid ^ (orderid >>> 32));
        result = 31 * result + (customerid != null ? customerid.hashCode() : 0);
        result = 31 * result + (employeeid != null ? employeeid.hashCode() : 0);
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        result = 31 * result + (requireddate != null ? requireddate.hashCode() : 0);
        result = 31 * result + (shippeddate != null ? shippeddate.hashCode() : 0);
        result = 31 * result + (shipvia != null ? shipvia.hashCode() : 0);
        result = 31 * result + (freight != null ? freight.hashCode() : 0);
        result = 31 * result + (shipname != null ? shipname.hashCode() : 0);
        result = 31 * result + (shipaddress != null ? shipaddress.hashCode() : 0);
        result = 31 * result + (shipcity != null ? shipcity.hashCode() : 0);
        result = 31 * result + (shipregion != null ? shipregion.hashCode() : 0);
        result = 31 * result + (shippostalcode != null ? shippostalcode.hashCode() : 0);
        result = 31 * result + (shipcountry != null ? shipcountry.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderid")
    public Collection<OrderDetailsEntity> getOrderDetailsesByOrderid() {
        return orderDetailsesByOrderid;
    }

    public void setOrderDetailsesByOrderid(Collection<OrderDetailsEntity> orderDetailsesByOrderid) {
        this.orderDetailsesByOrderid = orderDetailsesByOrderid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    public CustomersEntity getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(CustomersEntity customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }

    @ManyToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid")
    public EmployeesEntity getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(EmployeesEntity employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }

    @ManyToOne
    @JoinColumn(name = "shipvia", referencedColumnName = "shipperid")
    public ShippersEntity getShippersByShipvia() {
        return shippersByShipvia;
    }

    public void setShippersByShipvia(ShippersEntity shippersByShipvia) {
        this.shippersByShipvia = shippersByShipvia;
    }
}
