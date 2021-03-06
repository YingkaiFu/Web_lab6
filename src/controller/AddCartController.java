package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.BookService;
import vo.Book;
import vo.Cart;
import vo.CartItem;

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
public class AddCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        double price = (double)(session.getAttribute("price"));
        BookService bookService = new BookService();
        int count = (int) session.getAttribute("count");
        int id = Integer.parseInt(request.getParameter("id"));
        List<CartItem> cart = ((Cart) session.getAttribute("cart")).getBookList();
        Book book = bookService.getBookById(id);
        CartItem temp = new CartItem(book.getId(), book.getName(),
                book.getAuthor(), book.getPrice(), book.getImage(),
                book.getDescription(), book.getCategory_id(), 1);
        price = price+book.getPrice();
        session.setAttribute("price",price);
        if(cart.isEmpty()){
            count = count+1;
            cart.add(temp);
        }
        else {
            int flag=0;
            for (CartItem aCart : cart) {
                if (aCart.getName().equals(book.getName())) {
                    aCart.setNumber(aCart.getNumber() + 1);
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                cart.add(temp);
                count = count+1;
            }
        }

        Cart a = new Cart();
        for (CartItem i : cart
        ) {
            a.add(i);
        }
        System.out.println(a.getBookList());
        session.setAttribute("cart", a);
        session.setAttribute("count",count);
//        request.setAttribute("books",bookList);
//        request.getRequestDispatcher("/main.jsp").forward(request,response);
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(cart);
        PrintWriter out = response.getWriter();
//        System.out.println(jsonStr);
        out.write(jsonStr);
    }
}
