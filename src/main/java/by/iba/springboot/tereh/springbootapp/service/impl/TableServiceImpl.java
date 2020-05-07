package by.iba.springboot.tereh.springbootapp.service.impl;


import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.model.UserLog;
import by.iba.springboot.tereh.springbootapp.repository.TableRepository;
import by.iba.springboot.tereh.springbootapp.repository.UserLogRepository;
import by.iba.springboot.tereh.springbootapp.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private UserLogRepository userLogRepository;

    @Override
    public List<Tables> showTablesWithFields() {
        return tableRepository.showTables();
    }

    @Override
    public String executeQuery(String query, User user) {

        //проверки


        UserLog userLog = tableRepository.executeQuery(query);
        userLog.setUser(user);

        String result = userLog.getResult();

        if(userLog.getResult().length()>1000){
            userLog.setResult(userLog.getResult().substring(0,999));
        }
        userLogRepository.save(userLog);

        return result;
    }
}
