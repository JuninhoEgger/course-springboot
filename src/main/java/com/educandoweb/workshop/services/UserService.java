package com.educandoweb.workshop.services;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repositories.UserRepository;
import com.educandoweb.workshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        Optional<User> entity = repository.findById(id);
        updateData(entity.orElseThrow(() -> new ResourceNotFoundException(id)), user);
        return repository.save(entity.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
