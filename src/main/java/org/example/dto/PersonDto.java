package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.entity.Person;

public class PersonDto{
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonIgnore
    private int group;

    public PersonDto() {}

    public PersonDto(String name, String surname, int group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public PersonDto(Person person) {
        this.name = person.getFirstName();
        this.surname = person.getSurname();
        this.group = person.getGroup();
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

    @JsonIgnore
    public boolean isValid() {
        return !name.isBlank() && !surname.isBlank();
    }

    @Override
    public String toString() {
        return name + " " + surname + " из группы " + group;
    }
}
