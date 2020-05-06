package by.iba.springboot.tereh.springbootapp.controller;

import by.iba.springboot.tereh.springbootapp.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SqlExpressionController {

    @Autowired
    private TableService tableService;

    @GetMapping("/sql")
    public String getSQLTables(Model model){
        model.addAttribute("tables",tableService.showTablesWithFields());
        return "sql.html";
    }

}
