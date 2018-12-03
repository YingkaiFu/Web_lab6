package controller;


import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBookController")
public class AddBookController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookService();
        String bookname = request.getParameter("bookname");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String image = request.getParameter("image");
        String remark = request.getParameter("remark");


        boolean status = bookService.addBook(bookname,author,price,image,remark);
        request.setAttribute("status", status);
        if (status) {
            System.out.print("录入成功!");
            request.getRequestDispatcher("/adminpage.jsp").forward(request, response);
        } else {
            System.out.print("录入失败");
            request.getRequestDispatcher("/adminpage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
