package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.OrderService;
import vo.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetOrderByUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
    //by User
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        TODO
//        HttpSession session = request.getSession(false);
//        OrderService orderService = new OrderService();
//        List<Order> orderList = orderService.queryAll();
//
//
//
//        response.setCharacterEncoding("UTF-8");
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonStr = mapper.writeValueAsString(orderList);
//        PrintWriter out = response.getWriter();
//        System.out.println(jsonStr);
//        out.write(jsonStr);
    }
}
