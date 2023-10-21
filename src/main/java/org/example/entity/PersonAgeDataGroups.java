package org.example.entity;

public class PersonAgeDataGroups extends PersonGroups {
    public PersonAgeDataGroups() {
        super(20);
    }

    //возраст ученика
    public void addPerson(Person person) {
        int groupNumber = person.getAge();
        super.addPerson(person, groupNumber);
    }
}
