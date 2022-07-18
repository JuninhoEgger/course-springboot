package com.educandoweb.workshop.resources.apis;

import com.educandoweb.workshop.entities.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "User")
@RequestMapping("/users")
public interface UserApi {

    @ApiOperation(
            value = "Busca todos os usuários",
            nickname = "findAll",
            notes = "Busca todos os usuários do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class)})
    @GetMapping(value = "/find-all",
            produces = {"application/json"})
    ResponseEntity<List<User>> findAll(
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Busca um usuário do banco",
            nickname = "findById",
            notes = "Busca um usuário do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class)})
    @GetMapping(value = "/find-by-id/{id}",
            produces = {"application/json"})
    ResponseEntity<User> findById(
            @ApiParam(value = "O id do usuário", required = true)
            @PathVariable("id") Long id,
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Insere um usuário no banco",
            nickname = "insert",
            notes = "Insere um usuário do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED", response = User.class)})
    @PostMapping(value = "/insert",
            produces = {"application/json"})
    ResponseEntity<User> insert(
            @ApiParam(value = "User", required = true)
            @PathVariable("User")
            @RequestBody User user,
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Deleta um usuário no banco",
            nickname = "insert",
            notes = "Deleta um usuário do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class)})
    @DeleteMapping(value = "/delete-by-id/{id}",
            produces = {"application/json"})
    ResponseEntity<Void> deleteById(
            @ApiParam(value = "O id do usuário", required = true)
            @PathVariable("id") Long id,
            HttpServletRequest request
    );

    @ApiOperation(
            value = "Insere um usuário no banco",
            nickname = "insert",
            notes = "Insere um usuário do banco de de dados em caso de sucesso",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class)})
    @PutMapping(value = "/delete-by-id/{id}",
            produces = {"application/json"})
    ResponseEntity<User> update(
            @ApiParam(value = "O id do usuário", required = true)
            @PathVariable("id") Long id,
            @PathVariable("User") @RequestBody User user,
            HttpServletRequest request
    );

}
