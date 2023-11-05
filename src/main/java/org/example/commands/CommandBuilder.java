package org.example.commands;

import org.example.commands.console.GradeACommand;
import org.example.commands.console.MeanGradeCommand;
import org.example.commands.console.PersonSearchCommand;
import org.example.commands.transaction.DBGradeA;
import org.example.commands.transaction.DBMeanGrade;
import org.example.commands.transaction.DBSearch;
import org.example.service.JDBCService;
import org.example.service.StudentService;
import org.example.util.CSVDataLoader;

public class CommandBuilder {
    private final StudentService studentService;
    private final JDBCService jdbcService;

    public CommandBuilder() {
        studentService = new StudentService(new CSVDataLoader());
        jdbcService = new JDBCService();
    }

    public void parseCommand(ECommandType commandType, String value) {
        ICommand command;
        switch (commandType)
        {
            case MEANGRADECOMMAND -> command = new MeanGradeCommand<>(studentService.getClassroomDataGroups(), Integer.parseInt(value));
            case GRADEACOMMAND -> command = new GradeACommand<>(studentService.getPersonAgeDataGroups(), Integer.parseInt(value));
            case SEARCHCOMMAND -> command = new PersonSearchCommand<>(studentService.getPersonNameDataGroup(), value.charAt(0), value);
            case DBMEANGRADE -> command = new DBMeanGrade(jdbcService, Integer.parseInt(value));
            case DBGRADEA -> command = new DBGradeA(jdbcService, Integer.parseInt(value));
            case DBSEARCH -> command = new DBSearch(jdbcService, value);
            default -> command = null;
        }
        if (command != null)
            command.execute();
    }
}
