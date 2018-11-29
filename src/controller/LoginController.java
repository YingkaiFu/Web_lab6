package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        String username = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        boolean status = userService.login(username, pwd);
        if (status) {
            System.out.print("登录成功!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);//这里不知道往哪个页面跳转
        } else {
            System.out.print("登录失败");
            response.sendRedirect("/login.jsp");
        }
    }


}