package by.iba.springboot.tereh.springbootapp.repository.impl;

import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
