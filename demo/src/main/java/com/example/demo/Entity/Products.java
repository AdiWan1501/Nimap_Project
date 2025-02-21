package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productid;

    @Column(name = "productname")
    private String productname;

    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;
    
    public int getProductid() 
    {
        return productid;
    }
    
    public void setProductid(int pid) 
    {
        this.productid = pid;
    }
    
    public String getProductname() 
    {
        return productname;
    }
    
    public void setProductname(String pname) 
    {
        this.productname = pname;
    }
    
    public Category getCategory() 
    {
        return category;
    }

    public void setCategory(Category cat)
    {
    	this.category = cat;
    }
}