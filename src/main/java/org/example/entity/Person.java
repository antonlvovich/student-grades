package org.example.entity;

import org.example.dto.PersonDto;

public class Person {
    private final String surname;
    private final String firstName;
    private final int age;
    private final int group;
    private final Grade grade;

    public Person (String surname, String firstName, int age, int group, Grade grade) {
        this.surname = surname;
        this.firstName = firstName;
        this.age = age;
        this.group = group;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    public char getSurnameFirstLetter() {
        return surname.charAt(0);
    }

    public String getSurname() {
        return surname;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade.updateValue(grade);
    }

    public boolean equals(PersonDto person) {
        return this.firstName.equals(person.getName()) &&
                this.surname.equals(person.getSurname()) &&
                this.group == person.getGroup();
    }
    @Override
    public String toString() {
        return firstName + " " + surname;
    }

}
