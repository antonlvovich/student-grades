package org.example.commands.console;

import org.example.commands.ICommand;
import org.example.entity.DataGroup;

public class MeanGradeCommand<T> implements ICommand {
    private final DataGroup<T> dataGroup;
    private final T key;

    public MeanGradeCommand(DataGroup<T> dataGroup, T key) {
        this.dataGroup = dataGroup;
        this.key = key;
    }

    @Override
    public void execute() {
        if (dataGroup.getPersons(key) == null) {
            System.out.println("Нет запрашиваемой группы");
            return;
        }
        float sum = 0f;
        int length = dataGroup.getPersons(key).size();
        for (var p : dataGroup.getPersons(key)) {
            sum += p.getGrade().getMeanGrade();
        }
        System.out.println("Средняя оценка в классе " + key + ": " + sum / length);
    }
}
