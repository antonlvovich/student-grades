package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.GroupDto;
import org.example.dto.PersonDto;
import org.example.dto.PersonGradeDto;
import org.example.entity.ESubjectType;
import org.example.entity.Grade;
import org.example.service.StudentService;
import org.example.util.CSVDataLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/groups/*"})
public class PersonServlet extends HttpServlet {
    private final StudentService studentService = new StudentService(new CSVDataLoader());

    private final String AVG_MARK = "avg_marks";
    private final String STUDENTS = "students";
    private final String MARKS = "marks";

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] params = req.getPathInfo().split("/");
        if (params.length == 8) {
            if (params[2].equals(STUDENTS) || params[5].equals(MARKS)) {
                updateStudent(params);
                resp.setStatus(HttpServletResponse.SC_OK);
                return;
            }
        }
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    private void updateStudent(String[] params) {
        try {
            int group = Integer.parseInt(params[1]);
            String name = params[3];
            String surname = params[4];
            String subjectName = params[6];
            int mark = Integer.parseInt(params[7]);
            ESubjectType subject = ESubjectType.getType(subjectName);
            Grade grade = new Grade(subject, mark);
            PersonGradeDto personDto = new PersonGradeDto(name, surname, group, grade);
            studentService.changePersonGrade(personDto);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        String[] params = req.getPathInfo().split("/");
        int group = -1;
        if (params.length == 2 || params.length == 3) {
            try {
                group = Integer.parseInt(params[1]);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        GroupDto<? extends PersonDto> studentsGroup = null;
        if (params.length == 2) {
            studentsGroup = studentService.getByGroup(group);
        } else if (params.length == 3 && params[2].equals(AVG_MARK))
            studentsGroup = studentService.getMeanGroupGrade(group);
        mapper.writeValue(out, studentsGroup);

    }
}
