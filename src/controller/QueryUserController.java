package controller;

import service.BookService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/QueryUserController")
public class QueryUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService=new UserService();
        ArrayList<Map> users=userService.quaryUsers();
        request.setAttribute("Users",users);
        request.getRequestDispatcher("/QueryUser.jsp").forward(request,response);
    }
}
