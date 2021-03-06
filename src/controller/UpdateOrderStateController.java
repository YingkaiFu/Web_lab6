package controller;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateOrderStateController")
public class UpdateOrderStateController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean toUpdateState = Boolean.parseBoolean(request.getParameter("toUpdateState"));
        int toUpdateOrderId = Integer.parseInt(request.getParameter("toUpdateOrderId"));
        OrderService orderService = new OrderService();
        orderService.updateOrderState(toUpdateState, toUpdateOrderId);
        System.out.println("UpdateOrderStateController Executed");
        response.sendRedirect("QueryInit.jsp");
    }
}