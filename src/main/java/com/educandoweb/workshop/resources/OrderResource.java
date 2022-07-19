package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.resources.apis.OrderApi;
import com.educandoweb.workshop.services.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Controller
@Api(tags = {"Order"})
public class OrderResource implements OrderApi {

    @Autowired
    private OrderService service;

    @Override
    public ResponseEntity<List<Order>> findAll(HttpServletRequest request) {
        log.info("Buscando todos os pedidos na tabela orders");
        return ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<Order> findById(@PathVariable Long id, HttpServletRequest request) {
        log.info("Buscando o pedido de id {}", id);
        return ok().body(service.findById(id));
    }

}
