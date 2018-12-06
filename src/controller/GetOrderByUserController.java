package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.OrderService;
import vo.Order;
import vo.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GetOrderByUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
    //by User
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int)session.getAttribute("user_id");
        OrderService orderService = new OrderService();
        List<Order> userOrderList = orderService.getOrderByUserId(user_id);

        StringBuilder jsonStr = null;
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();

        for (Order anUserOrderList : userOrderList) {
            int order_id = anUserOrderList.getId();
            List<OrderItem> userOrderItemList = orderService.getOrderItemByOrderId(order_id);
            String jsonStrTemp = mapper.writeValueAsString(userOrderItemList);
            jsonStr.append(jsonStrTemp);
        }

        PrintWriter out = response.getWriter();
        System.out.println(jsonStr);
        out.write(jsonStr.toString());

    }
}
