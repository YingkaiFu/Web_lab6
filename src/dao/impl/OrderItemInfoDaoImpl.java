package dao.impl;

import dao.JDBCUtil;
import dao.OrderItemInfoDao;
import vo.OrderItem;
import vo.OrderItemInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemInfoDaoImpl implements OrderItemInfoDao {
    @Override
    public List<OrderItemInfo> getOrderItemInfoByOrderId(int order_id) {
        List<OrderItemInfo> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "SELECT order_id, name, quantity, book.price AS book_price, 'order'.price AS order_price FROM orderitem, book, 'order' WHERE orderitem.book_id = book.id AND 'order'.id = orderitem.order_id AND order_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,order_id);
            rs = ps.executeQuery();

            while (rs.next()){
                OrderItemInfo orderItemInfo = new OrderItemInfo();
                orderItemInfo.setOrder_id(rs.getInt("order_id"));
                orderItemInfo.setName(rs.getString("name"));
                orderItemInfo.setQuantity(rs.getInt("quantity"));
                orderItemInfo.setItem_price(rs.getDouble("book_price") * rs.getInt("quantity"));
                orderItemInfo.setOrder_price(rs.getDouble("order_price"));
                list.add(orderItemInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(conn);
        }
        return list;
    }
}
