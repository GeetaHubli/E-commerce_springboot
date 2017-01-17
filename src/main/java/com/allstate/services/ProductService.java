package com.allstate.services;

import com.allstate.entities.Product;
import com.allstate.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@Service
public class ProductService {

    private IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository){
        this.repository = repository;
    }

    public Product create(Product p){
        return this.repository.save(p);
    }

    public Product findById(int id) {
        return this.repository.findOne(id);
    }

    public Iterable<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findByName(String name) {
        return this.repository.findByName(name);
    }

    public void delete(int id) {
        this.repository.delete(id);
    }

    public Product findByStockNumber(String stocknumber) {
        return this.repository.findByStocknumber(stocknumber);
    }

    public Product update(int id, Product product) {
        Product find = findById(id);
        if(find != null){
            find.setName(product.getName());
            find.setStocknumber(product.getStocknumber());
            find.setDescription(product.getDescription());
            find.setRating(product.getRating());
            find.setNoofreviews(product.getNoofreviews());
            find.setListprice(product.getListprice());
            find.setPercentagediscount(product.getPercentagediscount());
            find.setActualprice(product.getActualprice());
            find.setQuantity(product.getQuantity());
            find.setRestricted(product.isRestricted());
            Product updateProduct = this.repository.save(find);
            return updateProduct;
        }
        return null;
    }
}
