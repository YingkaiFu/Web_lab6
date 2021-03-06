package dao;

import vo.OrderItem;
import vo.Order;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface OrderDao {
    List<Order> getOrderByUserId(int user_id);
    List<Order> getOrderByState(boolean state);
    List<Order> queryAll();
    Order getOrderById(int id) throws SQLException;
    int addOrder(Date ordertime, double price, boolean state, int user_id);
    boolean updateOrderState(boolean state, int order_id);
}



