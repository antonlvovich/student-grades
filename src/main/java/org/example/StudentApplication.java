package org.example;

import org.example.util.CSVDataLoader;
import org.example.service.StudentService;

import java.util.Scanner;

public class StudentApplication {
    private final StudentService studentService;

    public StudentApplication() {
        studentService = new StudentService(new CSVDataLoader());
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
            studentService.parseCommand(stringArray[0], stringArray[1]);
        }
    }

    private void printMenu() {
        System.out.println("""
                -1 <число> -- средняя оценка в классе <>
                -2 <число> -- поиск отличников среди учащихся возрастом <>
                -3 <строка> -- поиск учеников с фамилией <>""");
    }
}