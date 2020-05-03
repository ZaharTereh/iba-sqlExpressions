package by.iba.springboot.tereh.springbootapp.security.details;

import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.repository.UserRepository;
import by.iba.springboot.tereh.springbootapp.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userCandidate = userRepository.findOneByUsername(username);
        if(userCandidate.isPresent()){
            return new UserDetailsImpl(userCandidate.get());
        }
        else throw new IllegalArgumentException("User not found");

     /*   return new UserDetailsImpl(userRepository.findOneByUsername(username)
                .orElseThrow(IllegalAccessError::new));*/
    }
}
