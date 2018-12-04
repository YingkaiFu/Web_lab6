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
        if (username.equals("admin") && pwd.equals("admin")) {
            response.sendRedirect("/adminpage.jsp");
        } else {
            int count = 0;
            double price = 0.00;
            Cart cart = new Cart();
            boolean status = userService.login(username, pwd);

            int user_id = userService.getIdByName(username);
            if (status) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("count", count);
                session.setAttribute("cart", cart);
                session.setAttribute("price", price);
                session.setAttribute("state",false);
                session.setAttribute("user_id",user_id);
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


}