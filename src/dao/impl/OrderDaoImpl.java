package dao.impl;

import dao.JDBCUtil;
import dao.OrderDao;
import org.sqlite.JDBC;
import vo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> getOrderByUser(int user_id) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs ;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id,ordertime,price,state,user_id FROM 'order' WHERE user_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();

            while (rs.next()){
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrdertime(rs.getTime("ordertime"));
                order.setPrice(rs.getDouble("price"));
                order.setState(rs.getBoolean("state"));
                order.setUser_id(rs.getInt("user_id"));
                list.add(order);
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
    public boolean addOrder(int order_id, Date ordertime, double price, boolean state, int user_id) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO 'order'(id,ordertime,price,state,user_id) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,order_id);
            ps.setDate(2, (java.sql.Date) ordertime);
            ps.setDouble(3,price);
            ps.setBoolean(4,state);
            ps.setInt(5,user_id);
            if(ps.executeUpdate() > 0)
                status = true;

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return status;

    }
}
