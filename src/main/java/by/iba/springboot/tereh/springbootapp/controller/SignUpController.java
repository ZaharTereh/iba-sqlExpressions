package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.form.UserForm;
import by.iba.springboot.tereh.springbootapp.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/signUp")
    public String signUp(Model model,@ModelAttribute UserForm userForm){
        signUpService.signUp(userForm);
        model.addAttribute("signUp","Registration completed successfully");
        return "login.html";
    }
}
