package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.entity.Person;

public class PersonMeanGradeDto extends PersonDto {
    @JsonProperty("meanGrade")
    private double meanGrade;

    public PersonMeanGradeDto() {}

    public PersonMeanGradeDto(String name, String surname, int group, double meanGrade) {
        super(name, surname, group);
        this.meanGrade = meanGrade;
    }

    public PersonMeanGradeDto(Person person) {
        super(person);
        this.meanGrade = person.getGrade().getMeanGrade();
    }

    @Override
    public String toString() {
        return super.toString() + " со средним баллом " + meanGrade;
    }
}
