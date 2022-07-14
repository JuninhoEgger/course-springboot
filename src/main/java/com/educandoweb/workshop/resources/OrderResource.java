package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping("/find-all")
    public ResponseEntity<List<Order>> findAll() {
        return ok().body(service.findAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ok().body(service.findById(id));
    }

}
