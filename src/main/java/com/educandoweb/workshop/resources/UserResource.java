package com.educandoweb.workshop.resources;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequestUri;

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

    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User user) {
        log.info("Inserindo o user {}", user.getName());
        user = service.insert(user);
        URI uri = fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return created(uri).body(user);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Deletando o usuário com o id {}", id);
        service.deleteById(id);
        return noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        log.info("Atualizando os dados do usuário com id {}", id);
        return ResponseEntity.ok().body(service.update(id, user));
    }

}
