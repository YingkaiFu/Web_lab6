package dao;

import vo.OrderItemInfo;

import java.util.List;

public interface OrderItemInfoDao {
    List<OrderItemInfo> getOrderItemInfoByOrderId(int order_id);

}

