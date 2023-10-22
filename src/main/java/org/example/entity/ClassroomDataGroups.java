package org.example.entity;

public class ClassroomDataGroups extends PersonGroups{
    public ClassroomDataGroups(int size) {
        super(size);
    }

    //класс ученика
    public void addPerson(Person person) {
        int groupNumber = person.getGroup();
        super.addPerson(person, groupNumber);
    }
}
