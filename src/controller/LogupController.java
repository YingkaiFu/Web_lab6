package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogupController")
public class LogupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        String username = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String add = request.getParameter("add");

        System.out.print(username);
        System.out.print(pwd);
        boolean status = userService.logup(username, pwd, phone, tel, email, add);
        response.setCharacterEncoding("gb2312");
        request.setAttribute("status", status);
        if (status) {
            System.out.print("注册成功!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            System.out.print("注册失败");
            request.getRequestDispatcher("/logup.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
