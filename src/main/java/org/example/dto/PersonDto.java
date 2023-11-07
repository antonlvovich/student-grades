package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.entity.Grade;
import org.example.entity.Person;

public class PersonDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("group")
    private int group;
    @JsonProperty("grade")
    private Grade grade;

    public PersonDto() {}

    public PersonDto(String name, String surname, int group, Grade grade) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.grade = grade;
    }

    public PersonDto(Person person) {
        this.name = person.getFirstName();
        this.surname = person.getSurname();
        this.group = person.getGroup();
        this.grade = person.getGrade();
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isValid() {
        return !name.isBlank() && !surname.isBlank();
    }

    @Override
    public String toString() {
        return name + " " + surname + " из группы " + group;
    }

    public Grade getGrade() {
        return grade;
    }
}
