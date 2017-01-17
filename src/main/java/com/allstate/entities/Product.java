package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.util.Date;
import java.util.DoubleSummaryStatistics;

@Entity
@Table(name="products",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name","stocknumber"}))
@Data

public class Product {

    private int id;
    private int version;
    private String name;
    private String stocknumber;
    private String description;
    private int rating;
    private int noofreviews;
    private Double listprice;
    private Double percentagediscount;
    private Double actualprice;
    private int quantity;
    private boolean restricted;
    private Date created;
    private Date modified;


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getStocknumber() {
        return stocknumber;
    }
    public void setStocknumber(String stocknumber) {
        this.stocknumber = stocknumber;
    }

    @Column(nullable = false)
    public Double getListprice() {
        return listprice;
    }
    public void setListprice(Double listprice) {
        this.listprice = listprice;
    }

    @Column(nullable = false)
    public Double getActualprice() {
        return actualprice;
    }
    public void setActualprice(Double actualprice) {
        this.actualprice = actualprice;
    }

    @Column(nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(nullable = false)
    public boolean isRestricted( ){return this.restricted;}
    public void setRestricted(boolean restricted){ this.restricted = restricted;}

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

}
