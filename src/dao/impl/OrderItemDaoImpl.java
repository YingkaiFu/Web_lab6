package dao.impl;

import dao.JDBCUtil;
import dao.OrderItemDao;
import vo.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {
    @Override
    public List<OrderItem> getOrderItemByOrderId(int order_id) {
        List<OrderItem> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id,quantity,price,order_id,book_id FROM orderitem WHERE order_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,order_id);
            rs = ps.executeQuery();

            while (rs.next()){
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt("id"));
                orderItem.setQuantity(rs.getInt("quantity"));
                orderItem.setPrice(rs.getDouble("price"));
                orderItem.setOrder_id(rs.getInt("order_id"));
                orderItem.setBook_id(rs.getInt("book_id"));
                list.add(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(conn);
        }
        return list;
    }

    @Override
    public boolean addOrderItem(int orderitem_id, int quantity, double price, int order_id, int book_id) {
        boolean state = false;
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO orderitem(id,quantity,price,order_id,book_id) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderitem_id);
            ps.setInt(2,quantity);
            ps.setDouble(3,price);
            ps.setInt(4,order_id);
            ps.setInt(5,book_id);
            if(ps.executeUpdate() > 0)
                state = true;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }


        return state;
    }
}
