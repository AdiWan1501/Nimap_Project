package com.example.demo.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private int categoryid;

    @Column(name = "categoryname")
    private String categoryname;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> products = new ArrayList<>();

    public int getCategoryid() 
    {
        return categoryid;
    }

    public void setCategoryid(int cid) 
    {
        this.categoryid = cid;
    }

    public String getCategoryname() 
    {
        return categoryname;
    }

    public void setCategoryname(String cname) 
    {
        this.categoryname = cname;
    }

    public List<Products> getProducts() 
    {
        return products;
    }
    
    public void setProduct(List<Products> p)
    {
    	this.products = p;
    }
}