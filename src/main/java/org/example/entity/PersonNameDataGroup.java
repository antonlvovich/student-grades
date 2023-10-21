package org.example.entity;

public class PersonNameDataGroup extends PersonGroups{
    public PersonNameDataGroup() {
        super(33);
    }

    //первая буква фамилии ученика
    public void addPerson(Person person) {
        int normalizedNumber = person.getSurnameFirstLetter() - 1040;
        super.addPerson(person, normalizedNumber);
    }
}
