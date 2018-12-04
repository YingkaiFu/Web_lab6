package controller;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//int order_id, Date ordertime, double price, boolean state, int user_id
@WebServlet("/AddOrderController")
public class AddOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService orderService = new OrderService();
        String price_s = request.getParameter("price");
        String state_s = request.getParameter("state");
        String user_id_s = request.getParameter("user_id");

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date ordertime = new Date();
        double price = Double.valueOf(price_s);
        boolean state = Boolean.getBoolean(state_s);
        int user_id = Integer.parseInt(user_id_s);

        boolean status = orderService.addOrder(ordertime, price, state, user_id);
        System.out.println(status);
        request.setAttribute("status", status);
        if (status) {
            System.out.print("下单成功!");
            request.getRequestDispatcher("/orderSuccess.jsp").forward(request, response);
        } else {
            System.out.print("下单失败");
            request.getRequestDispatcher("/orderFail.jsp").forward(request, response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
