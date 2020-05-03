package by.iba.springboot.tereh.springbootapp.service.impl;

import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.model.UserLog;
import by.iba.springboot.tereh.springbootapp.repository.UserLogRepository;
import by.iba.springboot.tereh.springbootapp.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogRepository repository;

    @Override
    public List<UserLog> findUserLogs(User user) {
        List<UserLog> userLogs = repository.findUserLogsByUserIs(user);
        return userLogs;
    }
}
