package org.example.dto;

public class PersonDto {
    private String name;
    private String surname;
    private int group;
    private double meanGrade;

    public PersonDto() {}

    public PersonDto(String name, String surname, int group, double meanGrade) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.meanGrade = meanGrade;
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

    @Override
    public String toString() {
        return name + " " + surname + " из группы" + group + " со средним баллом" + meanGrade;
    }
}
