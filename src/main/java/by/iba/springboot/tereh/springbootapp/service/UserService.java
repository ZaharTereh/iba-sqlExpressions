package by.iba.springboot.tereh.springbootapp.service;

import by.iba.springboot.tereh.springbootapp.dto.UserDTO;
import by.iba.springboot.tereh.springbootapp.model.User;

public interface UserService {
    void update(UserDTO userDTO);
    User findUserById(Long id);
}
