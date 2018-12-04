package controller;

import service.OrderService;

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

//int order_id, Date ordertime, double price, boolean state, int user_id
@WebServlet("/AddOrderController")
public class AddOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("在add中");
        HttpSession session = request.getSession(false);
        System.out.println("在add中");
        OrderService orderService = new OrderService();
        System.out.println("在add中");
        double price = (double)session.getAttribute("price");
        System.out.println(session.getAttribute("price"));
        boolean state = (boolean)session.getAttribute("state");
        System.out.println(session.getAttribute("state"));
        int user_id = (int)session.getAttribute("user_id");
        System.out.println(session.getAttribute("user_id"));
        System.out.println("在add中");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date ordertime = new Date();
        boolean status = orderService.addOrder(ordertime, price,state, user_id);
        System.out.println("在add中");
        if (status) {
            System.out.print("下单成功!");
            request.getRequestDispatcher("/orderSuccess.jsp").forward(request, response);
        } else {
            System.out.print("下单失败");
            request.getRequestDispatcher("/orderFail.jsp").forward(request, response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
