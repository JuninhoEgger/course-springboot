package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.services.CategoryService;
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
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping("/find-all")
    public ResponseEntity<List<Category>> findAll() {
        log.info("Buscando todos as categorias na tabela categories");
        return ok().body(service.findAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        log.info("Buscando a categoria de id {}", id);
        return ok().body(service.findById(id));
    }

}
