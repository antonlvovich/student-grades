package org.example.service;

import org.example.dto.PersonMeanGradeDto;
import org.example.dto.SubjectGradeDto;
import org.example.dto.PersonDto;
import org.example.util.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCService {
    private static final String FIND_MEAN_GRADE_QUERY =
            """
            select classId, subjectName, avg(mark) as markValue from grade where classId = ?
            group by classId, subjectName;""";

    private static final String FIND_ALL_GRADE_A_QUERY =
            """
            select lastName, firstName, class from person
            inner join grade on grade.studentId = PERSON.id
            where age = ?
            group by PERSON.id
            having avg(mark) = 5;""";

    private static final String FIND_PERSON_BY_SURNAME_QUERY =
            """
            select lastName, firstName, class, avg(grade.mark) as meanMark\s
            from person inner join grade on grade.studentId = PERSON.id where lastName = ?\s
            group by person.id""";

    public List<SubjectGradeDto> getMeanGradeByDiscipline(int groupNumber) {
        List<SubjectGradeDto> grades = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(FIND_MEAN_GRADE_QUERY);
            statement.setInt(1, groupNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                SubjectGradeDto grade = new SubjectGradeDto(
                        resultSet.getString("subjectName"),
                        resultSet.getInt("classId"),
                        resultSet.getDouble("markValue")
                );
                grades.add(grade);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return grades;
    }

    public List<PersonDto> getGradeAStudents(int age)
    {
        List<PersonDto> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(FIND_ALL_GRADE_A_QUERY);
            statement.setInt(1, age);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                PersonDto user = new PersonDto();
                user.setName(resultSet.getString("firstName"));
                user.setSurname(resultSet.getString("lastName"));
                user.setGroup(resultSet.getInt("class"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    public List<PersonMeanGradeDto> getBySurname(String surname) {
        List<PersonMeanGradeDto> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(FIND_PERSON_BY_SURNAME_QUERY);
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                PersonMeanGradeDto user = new PersonMeanGradeDto(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("class"),
                        resultSet.getDouble("meanMark")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
        return users;
    }

    private void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
