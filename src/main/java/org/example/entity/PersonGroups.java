package org.example.entity;

public class PersonGroups {
    private final Node<Person>[] groups;
    private final int[] groupSizes;
    private final int defaultSize;

    public PersonGroups(int defaultSize) {
        this.defaultSize = defaultSize;
        groups = new Node[defaultSize];
        groupSizes = new int[defaultSize];
        for (int i = 0; i < defaultSize; i++)
            groups[i] = new Node<>();
    }

    // алгоритм добавления студента в нужную группу согласно критерию
    public void addPerson(Person person, int groupNumber) {
        if (groups[groupNumber].getValue() == null) {
            groups[groupNumber].setValue(person);
            groupSizes[groupNumber] = 1;
        }
        else
        {
            Node<Person> node = new Node<>(person, groups[groupNumber]);
            groups[groupNumber] = node;
            groupSizes[groupNumber] += 1;
        }
    }

    // возвращает студентов конкретной группы
    public Person[] getPersons(int groupNumber) {
        if (groupSizes[groupNumber] < 1)
            return null;
        Person[] personArray = new Person[groupSizes[groupNumber]];
        Node<Person> currentNode = groups[groupNumber];
        int i = 0;
        while (currentNode != null) {
            personArray[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
            i++;
        }
        return personArray;
    }

    public int getDefaultSize() {
        return defaultSize;
    }
}
