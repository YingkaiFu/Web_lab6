package controller;

import service.UserService;
import vo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        UserService userService = new UserService();
        String username = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        int count = 0;
        Cart cart = new Cart();
        boolean status = userService.login(username, pwd);
        if (status) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("count", count);
            session.setAttribute("cart", cart);
            response.sendRedirect("/mainpage.jsp");
        } else {
            response.setCharacterEncoding("gb2312");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('登录失败');");
            out.print("location.href='/login.jsp';");
            out.print("</script>");
        }
    }


}