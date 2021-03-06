package by.iba.springboot.tereh.springbootapp.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
