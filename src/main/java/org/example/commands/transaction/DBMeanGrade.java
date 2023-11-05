package org.example.commands.transaction;

import org.example.commands.ICommand;
import org.example.service.JDBCService;

public class DBMeanGrade implements ICommand {
    private final JDBCService jdbcService;
    private final int groupNumber;

    public DBMeanGrade (JDBCService jdbcService, int groupNumber) {
        this.jdbcService = jdbcService;
        this.groupNumber = groupNumber;
    }

    @Override
    public void execute() {
        jdbcService.getMeanGradeByDiscipline(groupNumber).forEach(System.out::println);
        System.out.println("Поиск завершен");
    }
}
