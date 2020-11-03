package com.springbootwithmysql.service;

import com.springbootwithmysql.dao.ProductRepository;
import com.springbootwithmysql.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }




    public void save(Product product){
        productRepository.save(product);
    }

    public Product get(Integer id){
        return productRepository.findById(id).get();
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
