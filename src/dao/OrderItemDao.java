package dao;

import vo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    List<OrderItem> getOrderItemByOrderId(int order_id);
    boolean addOrderItem(int orderitem_id, int quantity, double price, int order_id, int book_id);
}


