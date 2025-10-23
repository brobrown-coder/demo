package com.example.demo.user.service;

import java.util.List;

import com.example.demo.common.domain.Messenger;
import com.example.demo.user.domain.UserDTO;

public interface UserService {

    Messenger save(UserDTO userDTO);

    Messenger update(UserDTO userDTO);

    Messenger delete(UserDTO userDTO);

    Messenger findById(String id);

    Messenger findAll();

    Messenger saveAll(List<UserDTO> userDTOs);

}
