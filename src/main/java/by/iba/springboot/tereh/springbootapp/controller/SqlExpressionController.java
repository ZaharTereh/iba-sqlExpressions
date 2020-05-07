package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.model.Role;
import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.security.details.UserDetailsImpl;
import by.iba.springboot.tereh.springbootapp.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SqlExpressionController {

    @Autowired
    private TableService tableService;

    @GetMapping("/sql")
    public String getSQLTables(Model model){
        model.addAttribute("tables",tableService.showTablesWithFields());
        return "sql.html";
    }

    @PostMapping("/execute")
    public String executeQuery(Model model, Authentication authentication, HttpServletRequest request){
        User user = ((UserDetailsImpl)authentication.getPrincipal()).getUser();
        String query = request.getParameter("query");
        model.addAttribute("result",tableService.executeQuery(query,user));
        return getSQLTables(model);
    }


}
