package org.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGroup<T> {
    private final Map<T, List<Person>> groups;

    public DataGroup() {
        this.groups = new HashMap<>();
    }

    public void addPerson(Person person, T t) {
        groups.computeIfAbsent(t, k -> new ArrayList<>()).add(person);
    }

    public List<Person> getPersons(T t) {
        return groups.get(t);
    }
}
