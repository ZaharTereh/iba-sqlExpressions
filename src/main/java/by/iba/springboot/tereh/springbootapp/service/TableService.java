package by.iba.springboot.tereh.springbootapp.service;

import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.model.User;

import java.util.List;

public interface TableService {
    List<Tables> showTablesWithFields();
    String executeQuery(String query, User user);
}
