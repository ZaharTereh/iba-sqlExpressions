package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.dto.UserDTO;
import by.iba.springboot.tereh.springbootapp.security.details.UserDetailsImpl;
import by.iba.springboot.tereh.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @Autowired
    private UserService userService;

    @GetMapping("/menu")
    public String getMenu(Model model, Authentication authentication){
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        Long id = details.getUser().getId();
        model.addAttribute("user", UserDTO.from(userService.findUserById(id)));
        return "menu.html";
    }

}
