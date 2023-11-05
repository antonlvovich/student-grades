package org.example.commands.transaction;

import org.example.commands.ICommand;
import org.example.service.JDBCService;

public class DBSearch implements ICommand {
    private final JDBCService jdbcService;
    private final String surname;

    public DBSearch (JDBCService jdbcService, String surname) {
        this.jdbcService = jdbcService;
        this.surname = surname;
    }

    @Override
    public void execute() {
        jdbcService.getBySurname(surname).forEach(System.out::println);
        System.out.println("Поиск завершен");
    }
}
