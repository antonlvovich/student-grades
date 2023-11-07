package org.example.dto;

public class SubjectGradeDto {
    private final String subjectName;
    private final int groupNumber;
    private final double meanGrade;

    public SubjectGradeDto(String subjectName, int groupNumber, double meanGrade) {
        this.subjectName = subjectName;
        this.groupNumber = groupNumber;
        this.meanGrade = meanGrade;
    }
    @Override
    public String toString() {
        return subjectName + " " + groupNumber + " " + meanGrade;
    }
}
