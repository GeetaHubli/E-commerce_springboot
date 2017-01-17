package com.allstate.services;

import com.allstate.entities.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value={"/SQL/Seed.sql"})
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateProduct() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        Product created = this.service.create(p);
        assertEquals(2, created.getId());
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreateProductWithDuplicateName() throws Exception {
        Product p = new Product();
        p.setName("Ring");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        assertNull(this.service.create(p));
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreateProductWithDuplicateStockNumber() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("APB100");
        p.setActualprice(30000.0);
        assertNull(this.service.create(p));
    }

    @Test
    public void shouldFindProductById() throws Exception {
        Product found = this.service.findById(1);
        assertEquals(1, found.getId());
    }

    @Test
    public void shouldFindProductByBadId() throws Exception {
        assertNull(this.service.findById(10));
    }

    @Test
    public void shouldFindAllProducts() throws Exception{
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        this.service.create(p);
        List<Product> productList = (List<Product>) this.service.findAll();
        assertEquals(2, productList.size());
    }

    @Test
    public void shouldFindProductByName() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        this.service.create(p);
        Product found = this.service.findByName("Ring");
        assertEquals("Ring",found.getName());
    }

    @Test
    public void shouldFindProductByBadName() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        this.service.create(p);
        Product found = this.service.findByName("Geeta");
        assertNull(found);
    }

    @Test
    public void shouldFindProductByStockNumber() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        this.service.create(p);
        Product found = this.service.findByStockNumber("AXN007");
        assertEquals("Computer",found.getName());
    }

    @Test
    public void shouldFindProductByBadStockNumber() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        this.service.create(p);
        Product found = this.service.findByStockNumber("AX0000001000");
        assertNull(found);
    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        Product p = new Product();
        p.setName("Computer");
        p.setListprice(30000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(30000.0);
        this.service.create(p);
        Product found = this.service.findById(2);
        assertEquals("Computer", found.getName());
        this.service.delete(2);
        Product found2 = this.service.findById(2);
        assertNull(found2);
    }

    @Test
    public void shouldUpdateProductById() throws Exception {
        Product p = new Product();
        p.setName("Bottle");
        p.setDescription("update desc");
        p.setListprice(25000.0);
        p.setStocknumber("AXN007");
        p.setActualprice(25000.0);
        Product updated = this.service.update(1,p);
        assertEquals("Bottle",updated.getName());
    }
}
