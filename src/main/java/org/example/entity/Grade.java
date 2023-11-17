package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class Grade {
    private Map<ESubjectType, Integer> marks;

    public Grade() {}

    public Grade(ESubjectType subject, int mark) {
        this.marks = new HashMap<>();
        if (mark >= 1 && mark <= 5)
            marks.put(subject, mark);
    }

    public Grade(int[] subjectMarks) {
        if (subjectMarks.length != 6)
            return;
        this.marks = new HashMap<>();
        marks.put(ESubjectType.PHYS, subjectMarks[0]);
        marks.put(ESubjectType.MATH, subjectMarks[1]);
        marks.put(ESubjectType.RUS, subjectMarks[2]);
        marks.put(ESubjectType.LIT, subjectMarks[3]);
        marks.put(ESubjectType.GEOM, subjectMarks[4]);
        marks.put(ESubjectType.INF, subjectMarks[5]);
    }

    public void updateValue(Grade grade) {
        grade.marks.forEach((key,value) -> {
            if (value >= 1 && value <= 5)
                marks.put(key,value);
        });
    }

    public float getMeanGrade() {
        int sum = 0;
        for (var mark : marks.values())
            sum += mark;
        return (float) sum / marks.size();
    }

    public boolean isGradeA() {
        return getMeanGrade() == 5;
    }
}
