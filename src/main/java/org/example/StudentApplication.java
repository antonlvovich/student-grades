package org.example;

import org.example.commands.CommandBuilder;
import org.example.commands.ECommandType;

import java.util.Scanner;

public class StudentApplication {
    private final CommandBuilder commandBuilder;

    public StudentApplication() {
        commandBuilder = new CommandBuilder();
    }

    public void exec() {
        Scanner sc = new Scanner(System.in);
        printMenu();
        while (sc.hasNext()) {
            String commandline = sc.nextLine();
            String[] stringArray = commandline.split(" ");
            if (stringArray.length != 2) {
                System.out.println("Ошибка ввода");
                continue;
            }
            ECommandType eCommandType = ECommandType.getType(stringArray[0]);
            commandBuilder.parseCommand(eCommandType, stringArray[1]);
        }
    }

    private void printMenu() {
        System.out.println("""
                -1 <число> -- средняя оценка в классе <>
                -2 <число> -- поиск отличников среди учащихся возрастом <>
                -3 <строка> -- поиск учеников с фамилией <>
                -4 <число> -- СУБД, средние оценки по предметам в классах <>
                -5 <число> -- СУБД, список всех отличников старше <> лет
                -6 <строка> -- СУБД, средняя оценка ученика с указанной фамилией""");
    }
}