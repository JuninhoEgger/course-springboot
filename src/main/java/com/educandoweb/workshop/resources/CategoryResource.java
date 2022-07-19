package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.resources.apis.CategoryApi;
import com.educandoweb.workshop.services.CategoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Controller
@Api(tags = {"Category"})
public class CategoryResource implements CategoryApi {

    @Autowired
    private CategoryService service;

    @Override
    public ResponseEntity<List<Category>> findAll(HttpServletRequest request) {
        log.info("Buscando todos as categorias na tabela categories");
        return ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<Category> findById(@PathVariable Long id, HttpServletRequest request) {
        log.info("Buscando a categoria de id {}", id);
        return ok().body(service.findById(id));
    }

}
