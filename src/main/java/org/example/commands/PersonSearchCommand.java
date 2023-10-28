package org.example.commands;

import org.example.entity.DataGroup;
import org.example.entity.Person;

public class PersonSearchCommand<T> implements ICommand {
    private final DataGroup<T> dataGroup;
    private final T key;
    private final String surname;

    public PersonSearchCommand (DataGroup<T> dataGroup, T key, String surname) {
        this.dataGroup = dataGroup;
        this.key = key;
        this.surname = surname;
    }

    @Override
    public void execute() {
        if (dataGroup.getPersons(key) == null) {
            System.out.println("Нет учащихся с запрашиваемой фамилией");
            return;
        }
        for (Person p : dataGroup.getPersons(key)) {
            if (p.getSurname().equals(surname))
                System.out.println(p);
        }
    }
}
