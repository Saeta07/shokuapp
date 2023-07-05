package com.proyectosena.shokuapp.util;

import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.User;
import com.proyectosena.shokuapp.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Utils implements IUtils {

    private UserRepository userRepository;
    public User getUserById(final Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
