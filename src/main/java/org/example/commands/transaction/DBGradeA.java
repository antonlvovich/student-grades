package org.example.commands.transaction;

import org.example.commands.ICommand;
import org.example.service.JDBCService;

public class DBGradeA implements ICommand {
    private final JDBCService jdbcService;
    private final int age;

    public DBGradeA (JDBCService jdbcService, int age) {
        this.jdbcService = jdbcService;
        this.age = age;
    }

    @Override
    public void execute() {
        jdbcService.getGradeAStudents(age).forEach(System.out::println);
        System.out.println("Поиск завершен");
    }
}
