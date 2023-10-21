package org.example.entity;

public class Grade {
    private int physics;
    private int mathematics;
    private int russian;
    private int literature;
    private int geometry;
    private int informatics;

    public Grade(int[] marks) {
        if (marks.length != 6)
            return;
        this.physics = marks[0];
        this.mathematics = marks[1];
        this.russian = marks[2];
        this.literature = marks[3];
        this.geometry = marks[4];
        this.informatics = marks[5];
    }
    Grade(int physics, int mathematics, int russian, int literature, int geometry, int informatics) {
        this.physics = physics;
        this.mathematics = mathematics;
        this.russian = russian;
        this.literature = literature;
        this.geometry = geometry;
        this.informatics = informatics;
    }

    public float getMeanGrade() {
        int sum = physics + mathematics + russian + literature + geometry + informatics;
        return (float) sum / 6;
    }

    public boolean isGradeA() {
        return getMeanGrade() == 5;
    }
}
