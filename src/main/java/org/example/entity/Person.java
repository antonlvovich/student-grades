package org.example.entity;

public class Person {
    private String surname;
    private String firstName;
    private int age;
    private int group;
    private Grade grade;

    public Person (String surname, String firstName, int age, int group, Grade grade) {
        this.surname = surname;
        this.firstName = firstName;
        this.age = age;
        this.group = group;
        this.grade = grade;
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

    @Override
    public String toString() {
        return firstName + " " + surname;
    }
}
