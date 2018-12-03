package dao;

import vo.OrderItem;
import vo.Order;

import java.util.Date;
import java.util.List;

public interface OrderDao {
    List<Order> getOrderByUser(int user_id);
    boolean addOrder(int order_id, Date ordertime, double price, boolean state, int user_id);
}



