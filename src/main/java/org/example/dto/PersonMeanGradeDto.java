package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.entity.Person;

public class PersonMeanGradeDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("group")
    private int group;
    @JsonProperty("meanGrade")
    private double meanGrade;

    public PersonMeanGradeDto() {}

    public PersonMeanGradeDto(String name, String surname, int group, double meanGrade) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.meanGrade = meanGrade;
    }

    public PersonMeanGradeDto(Person person) {
        this.name = person.getFirstName();
        this.surname = person.getSurname();
        this.group = person.getGroup();
        this.meanGrade = person.getGrade().getMeanGrade();
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

    @Override
    public String toString() {
        return name + " " + surname + " из группы " + group + " со средним баллом " + meanGrade;
    }
}
