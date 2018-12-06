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

    }
}
