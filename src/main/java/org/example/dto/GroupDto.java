package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GroupDto<T> {
    @JsonProperty("persons")
    private List<T> personDtoList;
    @JsonProperty("size")
    private int size;

    public GroupDto() {}

    public GroupDto(List<T> persons) {
        personDtoList = persons;
        size = persons.size();
    }

    public List<T> getPersonDtoList() {
        return personDtoList;
    }

    public int getSize() {
        return size;
    }
}
