package com.proyectosena.shokuapp.servicio;

import com.proyectosena.shokuapp.dto.NewUserDTO;
import com.proyectosena.shokuapp.dto.UserDTO;
import com.proyectosena.shokuapp.enumeration.UserRole;
import com.proyectosena.shokuapp.exception.ExistingResourceException;
import com.proyectosena.shokuapp.model.User;
import com.proyectosena.shokuapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface UserService {

    List<User> listUsers();

    String getUserRole(User user);

    UserDTO getUserInfo(Long id);

    void addNewUser(NewUserDTO newUser);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}
