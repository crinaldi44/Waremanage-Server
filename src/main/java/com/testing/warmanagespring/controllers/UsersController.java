package com.testing.warmanagespring.controllers;

import com.testing.warmanagespring.exception.DuplicateResourceException;
import com.testing.warmanagespring.exception.ResourceNotFoundException;
import com.testing.warmanagespring.models.ListResponse;
import com.testing.warmanagespring.models.User;
import com.testing.warmanagespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/users")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public ListResponse<User> getUser(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            Collection<User> results = userRepository.findAll();
            return new ListResponse<>(200, "Successfully retrieved users", results);
        }
        Collection<User> results = userRepository.findAll().stream().filter(u -> u.getUsername().equals(name)).collect(Collectors.toList());
        return new ListResponse<>(200, "Successfully retrieved users", results);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return userRepository.getById(id);
    }

    @PostMapping(consumes = "application/json")
    public User createUser(@RequestBody User user) throws DuplicateResourceException {

        for (User acc : userRepository.findAll()) {
            if (acc.getUsername().equals(user.getUsername())) {
                throw new DuplicateResourceException("UserAccount");
            }
        }

        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") int id, User user) throws ResourceNotFoundException {

        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException();
        }

        User acc = userRepository.getById(id);
        acc.setUsername(user.getUsername());
        acc.setPassword(user.getPassword());
        acc.setPermissionSet(user.getPermissionSet());

        return userRepository.save(acc);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws ResourceNotFoundException {

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }

        User acc = userRepository.getById(id);
        userRepository.delete(acc);

        return ResponseEntity.ok().build();

    }

}
