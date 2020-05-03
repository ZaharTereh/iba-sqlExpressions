package by.iba.springboot.tereh.springbootapp.dto;

import by.iba.springboot.tereh.springbootapp.model.Role;
import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.security.details.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String username ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private Role role;

    public static UserDTO from(UserDetailsImpl userDetails){
        return UserDTO.builder()
                .id(userDetails.getUser().getId())
                .email(userDetails.getUser().getUserInfo().getEmail())
                .firstName(userDetails.getUser().getUserInfo().getFirstName())
                .lastName(userDetails.getUser().getUserInfo().getLastName())
                .role(userDetails.getUser().getRole())
                .username(userDetails.getUsername())
                .build();
    }

    public static UserDTO from(User user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getUserInfo().getFirstName())
                .lastName(user.getUserInfo().getLastName())
                .email(user.getUserInfo().getEmail())
                .role(user.getRole())
                .build();
    }
}
