package by.iba.springboot.tereh.springbootapp.service;

import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.model.UserLog;

import java.util.List;

public interface UserLogService {
    List<UserLog> findUserLogs(User user);
}
