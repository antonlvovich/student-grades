package org.example.service;

import org.example.commands.*;
import org.example.entity.*;
import org.example.criterion.*;
import org.example.util.DataLoader;

import java.util.List;

public class StudentService {
    private final DataGroup<Integer> personAgeDataGroups;
    private final DataGroup<Integer> classroomDataGroups;
    private final DataGroup<Character> personNameDataGroup;

    public StudentService(DataLoader loader) {
        IGroupCriterion<Integer> classCriterion = Person::getGroup;
        IGroupCriterion<Integer> ageCriterion = Person::getAge;
        IGroupCriterion<Character> surnameCriterion = Person::getSurnameFirstLetter;
        this.personAgeDataGroups = new DataGroup<>();
        this.classroomDataGroups = new DataGroup<>();
        this.personNameDataGroup = new DataGroup<>();
        List<String> personArray = loader.load("students.csv");
        for (String personString : personArray) {
            Person p = createStudent(personString);
            if (p == null) continue;
            personAgeDataGroups.addPerson(p, ageCriterion.getGroup(p));
            classroomDataGroups.addPerson(p, classCriterion.getGroup(p));
            personNameDataGroup.addPerson(p, surnameCriterion.getGroup(p));
        }
    }

    private Person createStudent(String line) {
        String[] param = line.split(";");
        if (param.length != 10) return null;
        int[] marks = new int[6];
        for (int i = 4; i < param.length; i++)
            marks[i - 4] = Integer.parseInt(param[i]);
        Grade studentGrades = new Grade(marks);
        return new Person(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), studentGrades);
    }

    public void parseCommand(String commandType, String value) {
        ICommand command;
        switch (commandType)
        {
            case "-1" -> command = new MeanGradeCommand<>(classroomDataGroups, Integer.parseInt(value));
            case "-2" -> command = new GradeACommand<>(personAgeDataGroups, Integer.parseInt(value));
            case "-3" -> command = new PersonSearchCommand<>(personNameDataGroup, value.charAt(0), value);
            default -> command = null;
        }
        if (command != null)
            command.execute();
    }
}
