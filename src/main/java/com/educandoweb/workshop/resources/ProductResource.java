package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.resources.apis.ProductApi;
import com.educandoweb.workshop.services.ProductService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Controller
@Api(tags = {"Product"})
public class ProductResource implements ProductApi {

    @Autowired
    private ProductService service;

    @Override
    public ResponseEntity<List<Product>> findAll(HttpServletRequest request) {
        log.info("Buscando todos os produtos na tabela products");
        return ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<Product> findById(@PathVariable Long id, HttpServletRequest request) {
        log.info("Buscando o produto de id {}", id);
        return ok().body(service.findById(id));
    }

}
