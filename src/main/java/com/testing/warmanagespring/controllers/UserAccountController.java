package com.testing.warmanagespring.controllers;

import com.testing.warmanagespring.exception.DuplicateResourceException;
import com.testing.warmanagespring.exception.ResourceNotFoundException;
import com.testing.warmanagespring.models.UserAccount;
import com.testing.warmanagespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/login")
public class UserAccountController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List<UserAccount> getUser(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return userRepository.findAll();
        }
        return userRepository.findAll().stream().filter(u -> u.getUsername().equals(name)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return userRepository.getById(id);
    }

    @PostMapping(consumes = "application/json")
    public UserAccount createUser(@RequestBody UserAccount user) throws DuplicateResourceException {

        for (UserAccount acc : userRepository.findAll()) {
            if (acc.getUsername().equals(user.getUsername())) {
                throw new DuplicateResourceException("UserAccount");
            }
        }

        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public UserAccount updateUser(@PathVariable(value = "id") int id, UserAccount user) throws ResourceNotFoundException {

        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException();
        }

        UserAccount acc = userRepository.getById(id);
        acc.setUsername(user.getUsername());
        acc.setPassword(user.getPassword());
        acc.setPrivileges(user.getPrivileges());

        return userRepository.save(acc);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws ResourceNotFoundException {

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }

        UserAccount acc = userRepository.getById(id);
        userRepository.delete(acc);

        return ResponseEntity.ok().build();

    }

}
