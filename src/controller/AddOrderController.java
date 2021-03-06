package controller;

import service.OrderService;
import vo.Cart;
import vo.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//int order_id, Date ordertime, double price, boolean state, int user_id
@WebServlet("/AddOrderController")
public class AddOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        OrderService orderService = new OrderService();
        double price = (double) session.getAttribute("price");
        boolean state = (boolean) session.getAttribute("state");
        int user_id = (int) session.getAttribute("user_id");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date ordertime = new Date();
        price = (double)Math.round(price*100)/100;
        int order_id = orderService.addOrder(ordertime, price, state, user_id);
        List<CartItem> cartItemList = ((Cart) session.getAttribute("cart")).getBookList();
        for (CartItem acart:cartItemList) {
            int item_quantity = acart.getNumber();
            double item_price = acart.getPrice();
            int book_id = acart.getId();
            int status = orderService.addOrderItem(item_quantity, item_price, order_id, book_id);
        }
        if (price >= 0) {
            if (order_id >= 0) {
                System.out.print("下单成功!");
                int count = 0;
                Cart cart = new Cart();
                price = 0.0;
                session.setAttribute("count", count);
                session.setAttribute("cart", cart);
                session.setAttribute("price", price);
                request.getRequestDispatcher("/orderSuccess.jsp").forward(request, response);
            }
        } else {
            System.out.print("下单失败");
            request.getRequestDispatcher("/orderFail.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
