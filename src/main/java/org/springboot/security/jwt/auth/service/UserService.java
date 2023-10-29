package org.springboot.security.jwt.auth.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springboot.security.jwt.auth.dao.entity.User;
import org.springboot.security.jwt.auth.dao.repository.UserRepository;
import org.springboot.security.jwt.auth.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElse(null);

        if(user == null){
            throw new EntityNotFoundException();
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setRoles(user.getRoles());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
