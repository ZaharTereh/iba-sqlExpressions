package by.iba.springboot.tereh.springbootapp.service.impl;

import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.repository.TableRepository;
import by.iba.springboot.tereh.springbootapp.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Override
    public List<Tables> showTablesWithFields() {
        return tableRepository.showTables();
    }
}
