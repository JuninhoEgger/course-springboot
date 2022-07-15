package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.services.UserService;
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
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll() {
        log.info("Buscando todos os usuários na tabela users");
        return ok().body(service.findAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        log.info("Buscando o usuário de id {}", id);
        return ok().body(service.findById(id));
    }

}
