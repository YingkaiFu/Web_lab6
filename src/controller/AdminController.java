package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str1=request.getParameter("AddBook");
        String str2=request.getParameter("QueryInit");
        String str3=request.getParameter("QueryFinish");
        String str4=request.getParameter("QueryUser");
        if("书籍信息录入".equals(str1)){
            response.sendRedirect("AddBook.jsp");
        }
        if("查询初始订单".equals(str2)){
            response.sendRedirect("QueryInit.jsp");
        }
        if("查询已完成订单".equals(str3)){
            response.sendRedirect("QueryFinish.jsp");
        }
        if("查询用户信息".equals(str4)){
            response.sendRedirect("QueryUser.jsp");
        }
    }
}
