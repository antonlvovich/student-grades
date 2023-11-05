package org.example.dto;

public class GradeDto {
    private final String subjectName;
    private final int groupNumber;
    private final double meanGrade;

    public GradeDto(String subjectName, int groupNumber, double meanGrade) {
        this.subjectName = subjectName;
        this.groupNumber = groupNumber;
        this.meanGrade = meanGrade;
    }
    @Override
    public String toString() {
        return subjectName + " " + groupNumber + " " + meanGrade;
    }
}
