package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.dto.UserDTO;
import by.iba.springboot.tereh.springbootapp.security.details.UserDetailsImpl;
import by.iba.springboot.tereh.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/updateForm")
    public String getUpdateForm(Model model, Authentication authentication){
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        Long id = details.getUser().getId();
        model.addAttribute("user", UserDTO.from(userService.findUserById(id)));
        return "update.html";
    }

    @PostMapping("/users")
    public String updateUser(@ModelAttribute("user") UserDTO userDTO){
        userService.update(userDTO);
        return "redirect:/menu";
    }

}
