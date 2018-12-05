package controller;


import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookService();
        String bookname = request.getParameter("bookname");
        String author = request.getParameter("author");
        int price = Integer.parseInt(request.getParameter("price"));
        String image = request.getParameter("image");
        String remark = request.getParameter("remark");


        boolean status = bookService.addBook(bookname,author,price,image,remark);
        request.setAttribute("status", status);
        if (status) {
            response.setCharacterEncoding("gb2312");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('录入成功');");
            out.print("location.href='/adminpage.jsp';");
            out.print("</script>");
        } else {
            response.setCharacterEncoding("gb2312");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('录入失败');");
            out.print("location.href='/adminpage.jsp';");
            out.print("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
