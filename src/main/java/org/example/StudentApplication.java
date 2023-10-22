package org.example;

import org.example.entity.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentApplication {
    private final PersonAgeDataGroups personAgeDataGroups;
    private final PersonNameDataGroup personNameDataGroup;
    private final ClassroomDataGroups classroomDataGroups;

    public StudentApplication() {
        personAgeDataGroups = new PersonAgeDataGroups(20);
        personNameDataGroup = new PersonNameDataGroup(16);
        classroomDataGroups = new ClassroomDataGroups(33);
        String filename = "students.csv";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                Person person = createStudent(line);
                if (person == null) continue;
                personAgeDataGroups.addPerson(person);
                personNameDataGroup.addPerson(person);
                classroomDataGroups.addPerson(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exec() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Средняя оценка в 10 классе "
                + getGroupMeanGrade(classroomDataGroups.getPersons(10)));
        System.out.println("Средняя оценка в 11 классе "
                + getGroupMeanGrade(classroomDataGroups.getPersons(11)));

        int age = 15;
        while (age < personAgeDataGroups.getDefaultSize()) {
            printGradeAStudents(personAgeDataGroups.getPersons(age));
            age++;
        }

        System.out.println("Введите фамилию студента, 0 выход");
        while (sc.hasNext()) {
            String surname = sc.next();
            printPersonBySurname(personNameDataGroup.getPersons(surname.charAt(0)), surname);
            if (surname.equals("0"))
                break;
        }
    }

    private Person createStudent(String line) {
        String[] param = line.split(";");
        if (param.length != 10) return null;
        int[] marks = new int[6];
        for (int i = 4; i < param.length; i++)
            marks[i - 4] = Integer.parseInt(param[i]);
        Grade studentGrades = new Grade(marks);
        return new Person(param[0], param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), studentGrades);
    }

    // 1) Вычисление средней оценки в старших классах (10 и 11)
    // В лучшем случае при использовании группировки по группе не потребуется выполнять проход всем элементам,
    // в худшем случае разницы нет
    private float getGroupMeanGrade(Person[] personArray) {
        if (personArray == null) return 0.0F;
        float sum = 0;
        for (Person p : personArray)
            sum += p.getGrade().getMeanGrade();
        return sum / personArray.length;
    }

    // 2) Поиск всех отличников, старше 14 лет
    // В лучшем случае при использовании группировки по возрасту не потребуется выполнять проход всем элементам,
    // в худшем случае разницы нет
    private void printGradeAStudents(Person[] personArray) {
        if (personArray != null) {
            for (Person p : personArray)
                if (p.getGrade().isGradeA()) {
                    System.out.println("Отличник старше 14 лет: " + p);
                }
        }
    }

    // 3) Поиск ученика по фамилии (фамилия ученика задается через консоль)
    // В лучшем случае при использовании группировки по первой букве имени не потребуется выполнять проход всем элементам,
    // в худшем случае разницы нет
    private void printPersonBySurname(Person[] personArray, String surname) {
        if (personArray != null) {
            for (Person p : personArray) {
                if (p.getSurname().equals(surname))
                    System.out.println(p);
            }
        }
    }
}
