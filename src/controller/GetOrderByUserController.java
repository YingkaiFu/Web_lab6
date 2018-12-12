package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.OrderService;
import vo.Order;
import vo.OrderItem;
import vo.OrderItemInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/GetOrderByUserController")
public class GetOrderByUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
    //by User
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        int user_id = (int)session.getAttribute("user_id");
        OrderService orderService = new OrderService();
        List<Order> userOrderList = orderService.getOrderByUserId(user_id);
        response.setCharacterEncoding("UTF-8");

        List<OrderItemInfo> lists = new ArrayList<>();
        for (Order anUserOrderList : userOrderList) {
            int order_id = anUserOrderList.getId();

            Date ordertime = anUserOrderList.getOrdertime();
            List<OrderItemInfo> userOrderItemInfoList = orderService.getOrderItemInfoByOrderId(order_id);
            lists.addAll(userOrderItemInfoList);
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(lists);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(format);
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
        System.out.println(jsonStr);
    }
}
