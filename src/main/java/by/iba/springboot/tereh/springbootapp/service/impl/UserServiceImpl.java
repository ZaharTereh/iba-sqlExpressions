package by.iba.springboot.tereh.springbootapp.service.impl;

import by.iba.springboot.tereh.springbootapp.dto.UserDTO;
import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.repository.UserRepository;
import by.iba.springboot.tereh.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long id){
        return userRepository.findUserById(id).get();
    }

    @Override
    public void update(UserDTO userDTO) {
        User user = userRepository.findUserById(userDTO.getId()).get();
        user.setUsername(userDTO.getUsername());
        user.getUserInfo().setEmail(userDTO.getEmail());
        user.getUserInfo().setFirstName(userDTO.getFirstName());
        user.getUserInfo().setLastName(userDTO.getLastName());
        userRepository.save(user);
    }
}
