package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.BookService;
import vo.Book;
import vo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getBookByID")
public class CartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookService();
        HttpSession session = request.getSession(false);
        int count = (int) session.getAttribute("count");
        int id = Integer.parseInt(request.getParameter("id"));
        List<Book> cart = ((Cart) session.getAttribute("cart")).getBookList();
        Book book = bookService.getBookById(id);
        cart.add(book);
        Cart a = new Cart();
        for (Book i : cart
        ) {
            a.add(i);
        }
        session.setAttribute("cart", a);
//        request.setAttribute("books",bookList);
//        request.getRequestDispatcher("/main.jsp").forward(request,response);
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(cart);
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
    }
}
