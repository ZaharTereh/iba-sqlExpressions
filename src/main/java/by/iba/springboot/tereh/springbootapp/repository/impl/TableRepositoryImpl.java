package by.iba.springboot.tereh.springbootapp.repository.impl;

import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.model.UserLog;
import by.iba.springboot.tereh.springbootapp.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TableRepositoryImpl implements TableRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String showNameOfTables = "show tables";
    private String showNameOfFields = "show columns from ";

    @Override
    public List<Tables> showTables() {
        List<Tables> tables = new ArrayList<>();
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(showNameOfTables);
        while (resultSet.next()){
            tables.add(
                    Tables.builder()
                    .name(resultSet.getString("Tables_in_iba"))
                    .fields(new ArrayList<String>())
                    .build());
        }
        for (Tables table:tables) {
            resultSet = jdbcTemplate.queryForRowSet(showNameOfFields + table.getName());
            while (resultSet.next()){
                table.getFields().add(resultSet.getString("Field"));
            }
        }

        return tables;
    }

    @Override
    public UserLog executeQuery(String query) {

        //проверка команды

        UserLog userLog = new UserLog();
        StringBuilder result = new StringBuilder();
        try {
            List<Map<String,Object>> list= jdbcTemplate.queryForList(query);
            for (Map<String,Object> map:list) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    result.append(entry.getKey() + " : " + entry.getValue() + ",");
                }
                result.append("-----------" + System.lineSeparator());
            }
            userLog.setMessage("Completed successfully");
            userLog.setResult(result.toString());

        }catch (Exception e){
            userLog.setMessage("Runtime error");
            userLog.setResult(e.getMessage());
        }
        userLog.setSqlQuery(query);
        return userLog;
    }
}
