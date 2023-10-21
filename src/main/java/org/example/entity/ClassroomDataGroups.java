package org.example.entity;

public class ClassroomDataGroups extends PersonGroups{
    public ClassroomDataGroups() {
        super(16);
    }

    //класс ученика
    public void addPerson(Person person) {
        int groupNumber = person.getGroup();
        super.addPerson(person, groupNumber);
    }
}
