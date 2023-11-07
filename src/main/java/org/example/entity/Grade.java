package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grade {
    @JsonProperty("phys")
    private int physics;
    @JsonProperty("math")
    private int mathematics;
    @JsonProperty("rus")
    private int russian;
    @JsonProperty("lit")
    private int literature;
    @JsonProperty("geom")
    private int geometry;
    @JsonProperty("inf")
    private int informatics;

    public Grade() {}

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
    public Grade(int physics, int mathematics, int russian, int literature, int geometry, int informatics) {
        this.physics = physics;
        this.mathematics = mathematics;
        this.russian = russian;
        this.literature = literature;
        this.geometry = geometry;
        this.informatics = informatics;
    }

    public Grade(Grade grade) {
        if (physics <= 0 || physics > 5)
            this.physics = grade.physics;
        if (mathematics <= 0 || mathematics > 5)
            this.mathematics = grade.mathematics;
        if (russian <= 0 || russian > 5)
            this.russian = grade.russian;
        if (literature <= 0 || literature > 5)
            this.literature = grade.literature;
        if (geometry <= 0 || geometry > 5)
            this.geometry = grade.geometry;
        if (informatics <= 0 || informatics > 5)
            this.informatics = grade.informatics;
    }

    public boolean isValid() {
        if (physics < 0 || physics > 5)
            return false;
        if (mathematics < 0 || mathematics > 5)
            return false;
        if (russian < 0 || russian > 5)
            return false;
        if (literature < 0 || literature > 5)
            return false;
        if (geometry < 0 || geometry > 5)
            return false;
        if (informatics < 0 || informatics > 5)
            return false;
        return true;
    }

    public float getMeanGrade() {
        int sum = physics + mathematics + russian + literature + geometry + informatics;
        return (float) sum / 6;
    }

    public boolean isGradeA() {
        return getMeanGrade() == 5;
    }
}
