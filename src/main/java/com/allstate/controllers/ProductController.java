package com.allstate.controllers;

import com.allstate.entities.Product;
import com.allstate.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductController {
    private ProductService service;

    @Autowired
    public void setService(ProductService service){this.service = service;}

    //POST of a product
    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    public Product create(@RequestBody Product p){ return  this.service.create(p);}
}
