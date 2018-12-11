package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import service.OrderService;
import vo.Order;
import vo.OrderItem;

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
//        StringBuilder jsonStr = new StringBuilder();
//        ObjectMapper mapper = new ObjectMapper();
//        System.out.println("In Controller GetOrderByUserController");
//
//        for (Order anUserOrderList : userOrderList) {
//            int order_id = anUserOrderList.getId();
//            Date ordertime = anUserOrderList.getOrdertime();
//            String orderInfo = "{\"order_id\":\""+order_id+"\",\"ordertime\":\""+ordertime+"\"}";
//            System.out.println(orderInfo);
//            List<OrderItem> userOrderItemList = orderService.getOrderItemByOrderId(order_id);
//            String jsonStrTemp = mapper.writeValueAsString(userOrderItemList);
//            jsonStr.append(orderInfo);
//            jsonStr.append(jsonStrTemp);
//        }
        List<OrderItem> lists = new ArrayList<>();
        for (Order anUserOrderList : userOrderList) {
            int order_id = anUserOrderList.getId();

            Date ordertime = anUserOrderList.getOrdertime();
            List<OrderItem> userOrderItemList = orderService.getOrderItemByOrderId(order_id);
            lists.addAll(userOrderItemList);
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
