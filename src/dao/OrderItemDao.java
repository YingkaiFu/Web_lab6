package dao;

import vo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    List<OrderItem> getOrderItemByOrderId(int order_id);
    int addOrderItem(int quantity, double price, int order_id, int book_id);
}


