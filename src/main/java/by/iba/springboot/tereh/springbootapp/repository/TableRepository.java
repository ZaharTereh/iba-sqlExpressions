package by.iba.springboot.tereh.springbootapp.repository;

import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.model.UserLog;

import java.util.List;

public interface TableRepository {
    List<Tables> showTables();
    UserLog executeQuery(String query);
}
