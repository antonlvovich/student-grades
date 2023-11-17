package org.example.service;

import org.example.dto.GroupDto;
import org.example.dto.PersonDto;
import org.example.dto.PersonGradeDto;
import org.example.dto.PersonMeanGradeDto;
import org.example.entity.*;
import org.example.criterion.*;
import org.example.util.DataLoader;

import java.util.ArrayList;
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
        List<String> personArray = loader.load("C:\\Users\\1\\IdeaProjects\\student-grades\\src\\main\\resources\\students.csv");
        for (String personString : personArray) {
            Person p = createStudent(personString);
            if (p == null) continue;
            personAgeDataGroups.addPerson(p, ageCriterion.getGroup(p));
            classroomDataGroups.addPerson(p, classCriterion.getGroup(p));
            personNameDataGroup.addPerson(p, surnameCriterion.getGroup(p));
        }
    }

    public DataGroup<Character> getPersonNameDataGroup() {
        return personNameDataGroup;
    }

    public DataGroup<Integer> getClassroomDataGroups() {
        return classroomDataGroups;
    }

    public DataGroup<Integer> getPersonAgeDataGroups() {
        return personAgeDataGroups;
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

    public GroupDto<PersonDto> getByGroup(Integer group) {
        List<PersonDto> personDto = new ArrayList<>();
        classroomDataGroups.getPersons(group).forEach(person -> personDto.add(new PersonDto(person)));
        return new GroupDto<>(personDto);
    }

    public GroupDto<PersonMeanGradeDto> getMeanGroupGrade(Integer group) {
        List<PersonMeanGradeDto> personDto = new ArrayList<>();
        classroomDataGroups.getPersons(group).forEach(person -> personDto.add(new PersonMeanGradeDto(person)));
        return new GroupDto<>(personDto);
    }

    public void changePersonGrade(PersonGradeDto person) {
        if (!person.isValid()) return;
        for (var x : classroomDataGroups.getPersons(person.getGroup())) {
            if (x.equals(person)) {
                x.setGrade(person.getGrade());
            }
        }
    }
}
