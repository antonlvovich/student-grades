package org.example.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.PersonDto;
import org.example.service.StudentService;
import org.example.util.CSVDataLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/person"})
public class PersonServlet extends HttpServlet {
    private final StudentService studentService = new StudentService(new CSVDataLoader());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String reqStr = new String(req.getInputStream().readAllBytes());
        var request = mapper.readValue(reqStr, PersonDto.class);
        if (!studentService.changePersonGrade(request))
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String groupId = request.getParameter("groupId");
        int group = Integer.parseInt(groupId);
        ObjectMapper mapper = new ObjectMapper();
        String limitStr = request.getParameter("limit");
        int limit = limitStr != null ? Integer.parseInt(limitStr) : -1;
        var arr = studentService.getMeanGroupGrade(group, limit);
        mapper.writeValue(out, arr);
    }
}
