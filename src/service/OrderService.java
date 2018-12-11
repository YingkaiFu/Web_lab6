package service;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import vo.Order;
import vo.OrderItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderDao order = new OrderDaoImpl();
    private OrderItemDao orderItem = new OrderItemDaoImpl();

    public List<Order> getOrderByUserId(int id){
        return order.getOrderByUserId(id);
    }
    public List<Order> getOrderByState(boolean state){
        return order.getOrderByState(state);
    }

    public List<Order> queryAll(){
        return order.queryAll();
    }
    public List<OrderItem> getOrderItemByOrderId(int order_id) {
        return orderItem.getOrderItemByOrderId(order_id);
    }
    public Order getOrderById(int id) throws SQLException {
        return order.getOrderById(id);
    }
    public int addOrder(Date ordertime, double price, boolean state, int user_id){
        return order.addOrder(ordertime, price, state, user_id);
    }
    public int addOrderItem(int quantity, double price, int order_id, int book_id){
        return orderItem.addOrderItem(quantity, price, order_id, book_id);
    }


}
