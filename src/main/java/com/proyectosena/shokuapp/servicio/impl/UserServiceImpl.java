package com.proyectosena.shokuapp.servicio.impl;

import com.proyectosena.shokuapp.dto.NewUserDTO;
import com.proyectosena.shokuapp.dto.UserDTO;
import com.proyectosena.shokuapp.enumeration.UserRole;
import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.User;
import com.proyectosena.shokuapp.repository.UserRepository;
import com.proyectosena.shokuapp.servicio.UserService;
import com.proyectosena.shokuapp.util.IUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final IUtils utils;

    //private final Map<Long, String> userRoles;

    private static final String EXISTING_USER_MESSAGE = "Employee already registered";

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, IUtils utils) {
        this.userRepository = userRepository;
        this.utils = utils;
    }


    @Override
    public List<User> listUsers() {
        logger.info("Retrieval all customers...");
        return userRepository.findAll();
    }
    @Override
    public String getUserRole(final User user) {
        return user.getUserRole().toString();
    }
    @Override
    public UserDTO getUserInfo(final Long id) {
        User user = utils.getUserById(id);

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getUserRole())
                .build();
    }

    @Override
    public void addNewUser(final NewUserDTO newUser) {
        logger.info("Insert a new customer ...");
        if (!userRepository.existsById(newUser.getId())) {
            User newAppUser = User.builder()
                    .id(newUser.getId())
                    .name(newUser.getName())
                    .lastName(newUser.getLastName())
                    .email(newUser.getEmail())
                    .userRole(UserRole.CUSTOMER)
                    .build();

            userRepository.save(newAppUser);
            log.info("User created successfully");
        } else {
            log.warn("Employee already registered");
            throw new IllegalStateException(EXISTING_USER_MESSAGE);
        }
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {

        logger.info("Update a customers ...");

        Optional<User> customerDb = userRepository.findById(id);

        if (customerDb.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        User users = utils.getUserById(id);

        user.setName(user.getName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());

        log.info("User updated successfully");

    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    /*public UserService(){
        userRoles = new HashMap<>();
        Objects.equals(userRoles.put(1L, "admin"), UserRole.ADMIN);
        Objects.equals(userRoles.put(2L, "manager"), UserRole.MANAGER);
        Objects.equals(userRoles.put(3L, "waiter"), UserRole.WAITER);
        Objects.equals(userRoles.put(4L, "customer"), UserRole.CUSTOMER);
    }*/

}
