package com.educandoweb.workshop.resources.apis;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.entities.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "Category")
@RequestMapping("/categories")
public interface CategoryApi {

    @ApiOperation(
            value = "Busca todos as categorias",
            nickname = "findAll",
            notes = "Busca todos as categorias do banco de de dados em caso de sucesso",
            response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Category.class)})
    @GetMapping(value = "/find-all",
            produces = {"application/json"})
    ResponseEntity<List<Category>> findAll(
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Busca uma categoria do banco",
            nickname = "findById",
            notes = "Busca uma categoria do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Category.class)})
    @GetMapping(value = "/find-by-id/{id}",
            produces = {"application/json"})
    ResponseEntity<Category> findById(
            @ApiParam(value = "O id da categoria", required = true)
            @PathVariable("id") Long id,
            HttpServletRequest request
    );

}
