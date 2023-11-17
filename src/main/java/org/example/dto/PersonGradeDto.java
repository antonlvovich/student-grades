package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.entity.Grade;

public class PersonGradeDto extends PersonDto{
    @JsonIgnore
    private final Grade grade;

    public PersonGradeDto(String name, String surname, int group, Grade grade) {
        super(name, surname, group);
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }
}
