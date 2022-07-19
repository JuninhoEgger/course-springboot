package com.educandoweb.workshop.resources.apis;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.entities.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "Product")
@RequestMapping("/products")
public interface ProductApi {

    @ApiOperation(
            value = "Busca todos os produtos",
            nickname = "findAll",
            notes = "Busca todos os produtos do banco de de dados em caso de sucesso",
            response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class)})
    @GetMapping(value = "/find-all",
            produces = {"application/json"})
    ResponseEntity<List<Product>> findAll(
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Busca um produto do banco",
            nickname = "findById",
            notes = "Busca um produto do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Category.class)})
    @GetMapping(value = "/find-by-id/{id}",
            produces = {"application/json"})
    ResponseEntity<Product> findById(
            @ApiParam(value = "O id do produto", required = true)
            @PathVariable("id") Long id,
            HttpServletRequest request
    );

}
