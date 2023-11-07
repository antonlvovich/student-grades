package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GroupDto {
    @JsonProperty("persons")
    private List<PersonMeanGradeDto> personDtoList;
    @JsonProperty("size")
    private int size;

    public GroupDto() {}

    public GroupDto(List<PersonMeanGradeDto> persons) {
        personDtoList = persons;
        size = persons.size();
    }

    public List<PersonMeanGradeDto> getPersonDtoList() {
        return personDtoList;
    }

    public int getSize() {
        return size;
    }
}
