package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
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
        request.setAttribute("status", status);
        response.setCharacterEncoding("gb2312");

        PrintWriter out = response.getWriter();
        if (username.isEmpty()|| pwd.isEmpty()){
            out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('用户名与密码不为空');");
            out.print("location.href='/signUp.jsp';");
        } else{

            if (status) {
                out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('注册成功');");
                out.print("location.href='/login.jsp';");
            } else {
                out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('注册失败');");
                out.print("location.href='/signUp.jsp';");
            }
        }
        out.print("</script>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
