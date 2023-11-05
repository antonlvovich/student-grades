package org.example.commands.console;

import org.example.commands.ICommand;
import org.example.entity.DataGroup;

public class GradeACommand<T> implements ICommand {
    private final DataGroup<T> dataGroup;
    private final T key;

    public GradeACommand (DataGroup<T> dataGroup, T key) {
        this.dataGroup = dataGroup;
        this.key = key;
    }

    @Override
    public void execute() {
        if (dataGroup.getPersons(key) == null) {
            System.out.println("Нет учащихся запрашиваемого возраста");
            return;
        }
        dataGroup.getPersons(key).forEach(p -> {
            if (p.getGrade().isGradeA()) {
                System.out.println(p + " отличник возрастом " + p.getAge() + " лет");
            }
        });
    }
}
