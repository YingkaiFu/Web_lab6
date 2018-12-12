package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.BookService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class QueryUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService=new UserService();
        List users=userService.quaryUsers();
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(users);
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
    }
}
