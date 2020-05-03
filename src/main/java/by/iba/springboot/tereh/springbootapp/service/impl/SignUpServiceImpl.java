package by.iba.springboot.tereh.springbootapp.service.impl;

import by.iba.springboot.tereh.springbootapp.model.Role;
import by.iba.springboot.tereh.springbootapp.model.State;
import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.model.UserInfo;
import by.iba.springboot.tereh.springbootapp.repository.UserRepository;
import by.iba.springboot.tereh.springbootapp.form.UserForm;
import by.iba.springboot.tereh.springbootapp.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void signUp(UserForm userForm) {
        User user = User.builder()
                    .username(userForm.getUsername())
                    .password(passwordEncoder.encode(userForm.getPassword()))
                    .role(Role.USER)
                    .state(State.ACTIVE)
                    .userInfo(UserInfo.builder()
                        .email(userForm.getEmail())
                        .firstName(userForm.getFirstName())
                        .lastName(userForm.getLastName())
                        .build())
                    .build();

        userRepository.save(user);
    }
}
