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
        String pricestr=request.getParameter("price");
        if(pricestr.isEmpty()) pricestr="0";
        int price = Integer.parseInt(pricestr);

        String image = request.getParameter("image");
        String remark = request.getParameter("remark");
        String category_str=request.getParameter("category_id");
        if(category_str.isEmpty()) category_str="0";
        int category_id= Integer.parseInt(category_str);




        response.setCharacterEncoding("gb2312");
        PrintWriter out = response.getWriter();
        if(bookname.isEmpty()||author.isEmpty()||pricestr=="0"||(category_id!=1&&category_id!=2&&category_id!=3)){
            out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('书籍信息不完整或类型错误，录入失败');");
            out.print("location.href='/adminpage.jsp';");
            out.print("</script>");
        }
        else {
            boolean status = bookService.addBook(bookname,author,price,image,remark,category_id);
            request.setAttribute("status", status);
            if (status) {

                out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('录入成功');");
                out.print("location.href='/adminpage.jsp';");
                out.print("</script>");
            } else {
                out.print("<script type='text/javascript' language='javascript' charset='gb2312'>alert('录入失败');");
                out.print("location.href='/adminpage.jsp';");
                out.print("</script>");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
