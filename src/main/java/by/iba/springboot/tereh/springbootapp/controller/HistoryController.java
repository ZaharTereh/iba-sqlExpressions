package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.repository.UserLogRepository;
import by.iba.springboot.tereh.springbootapp.security.details.UserDetailsImpl;
import by.iba.springboot.tereh.springbootapp.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    @Autowired
    private UserLogService userLogService;

    @GetMapping("/history")
    public String getHistory(Model model, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        model.addAttribute("userLogs",userLogService.findUserLogs(userDetails.getUser()));
        return "history.html";
    }
}
