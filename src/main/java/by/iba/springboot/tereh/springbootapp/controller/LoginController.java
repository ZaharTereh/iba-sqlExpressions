package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(Model model, HttpServletRequest request){
        if(request.getParameterMap().containsKey("error") ){
            model.addAttribute("error",true);
        }
        model.addAttribute("user",new UserDTO());
        return "login.html";
    }


}
