package com.proyectosena.shokuapp.service;

import com.proyectosena.shokuapp.dto.EditUserRoleDTO;
import com.proyectosena.shokuapp.dto.NewUserDTO;
import com.proyectosena.shokuapp.dto.UserDTO;
import com.proyectosena.shokuapp.model.User;

import java.util.List;


public interface UserService {

    List<User> listUsers();

    String getUserRole(User user);

    UserDTO getUserInfo(Long id);

    void addNewUser(NewUserDTO newUser);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    void changeUserRole(final Long id, final EditUserRoleDTO editUserDTO);

}
