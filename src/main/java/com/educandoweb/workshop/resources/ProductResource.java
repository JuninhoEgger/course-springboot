package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping("/find-all")
    public ResponseEntity<List<Product>> findAll() {
        log.info("Buscando todos os produtos na tabela products");
        return ok().body(service.findAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        log.info("Buscando o produto de id {}", id);
        return ok().body(service.findById(id));
    }

}
