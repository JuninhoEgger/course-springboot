package com.educandoweb.workshop.resources.apis;

import com.educandoweb.workshop.entities.Category;
import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "Order")
@RequestMapping("/orders")
public interface OrderApi {

    @ApiOperation(
            value = "Busca todos os pedidos",
            nickname = "findAll",
            notes = "Busca todos os pedidos do banco de de dados em caso de sucesso",
            response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Order.class)})
    @GetMapping(value = "/find-all",
            produces = {"application/json"})
    ResponseEntity<List<Order>> findAll(
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Busca um pedido do banco",
            nickname = "findById",
            notes = "Busca um pedido do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Category.class)})
    @GetMapping(value = "/find-by-id/{id}",
            produces = {"application/json"})
    ResponseEntity<Order> findById(
            @ApiParam(value = "O id do pedido", required = true)
            @PathVariable("id") Long id,
            HttpServletRequest request
    );

}
