package dao;

import vo.OrderItem;
import vo.Order;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface OrderDao {
    List<Order> getOrderByUserId(int user_id);
    List<Order> queryAll();
    Order getOrderById(int id) throws SQLException;
    boolean addOrder(Date ordertime, double price, boolean state, int user_id);
}



