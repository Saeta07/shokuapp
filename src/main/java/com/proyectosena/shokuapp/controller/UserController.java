package com.proyectosena.shokuapp.controller;

import com.proyectosena.shokuapp.dto.EditUserRoleDTO;
import com.proyectosena.shokuapp.dto.NewUserDTO;
import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.User;
import com.proyectosena.shokuapp.repository.UserRepository;
import com.proyectosena.shokuapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getEmployeeList() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody final NewUserDTO newUser) {
        userService.addNewUser(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<User> changeUserRole(@PathVariable Long id, @RequestBody EditUserRoleDTO editUserRoleDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserRole(editUserRoleDTO.getUserRole());
            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            log.info("User deleted successfully");
            return ResponseEntity.ok().build();
        } else {
            log.warn(ResourceNotFoundException.MESSAGE);
            throw new ResourceNotFoundException();
        }
    }

}
