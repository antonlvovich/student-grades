package org.example.service;

import org.example.dto.GroupDto;
import org.example.dto.PersonDto;
import org.example.dto.PersonGradeDto;
import org.example.dto.PersonMeanGradeDto;

public interface IStudentService {
    GroupDto<PersonDto> getByGroup(Integer group);
    GroupDto<PersonMeanGradeDto> getMeanGroupGrade(Integer group);
    void changePersonGrade(PersonGradeDto person);
}
