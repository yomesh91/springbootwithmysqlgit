package com.springbootwithmysql.controller;

import com.springbootwithmysql.entity.Product;
import com.springbootwithmysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> list() {
        return productService.listAll();
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") Integer id) {
        try {
            Product product = productService.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable("id") Integer id){
        try {
            Product product1 = productService.get(id);
            productService.save(product);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Integer id){
        productService.delete(id);
    }

}