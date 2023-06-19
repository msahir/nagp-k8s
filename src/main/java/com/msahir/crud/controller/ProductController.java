package com.msahir.crud.controller;

import com.msahir.crud.entity.Product;
import com.msahir.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
    private ProductRepository repository;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @GetMapping
    public List<Product> getProducts(){
        return repository.findAll();
    }

}
