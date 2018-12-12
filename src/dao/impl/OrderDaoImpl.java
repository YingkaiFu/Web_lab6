package dao.impl;

import dao.JDBCUtil;
import dao.OrderDao;
import dao.JDBCUtil;
import vo.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> getOrderByUserId(int user_id) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id,ordertime,price,state,user_id FROM 'order' WHERE user_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrdertime(rs.getDate("ordertime"));
                order.setPrice(rs.getDouble("price"));
                order.setState(rs.getBoolean("state"));
                order.setUser_id(rs.getInt("user_id"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<Order> getOrderByState(boolean state) {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id,ordertime,price,state,user_id FROM 'order' WHERE state = ?";
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, state);
            rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrdertime(rs.getDate("ordertime"));
                order.setPrice(rs.getDouble("price"));
                order.setState(rs.getBoolean("state"));
                order.setUser_id(rs.getInt("user_id"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return list;

    }

    @Override
    public List<Order> queryAll() {

        List<Order> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id,ordertime,price,state,user_id FROM 'order' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrdertime(rs.getDate("ordertime"));
                order.setPrice(rs.getDouble("price"));
                order.setState(rs.getBoolean("state"));
                order.setUser_id(rs.getInt("user_id"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return list;
    }

    @Override
    public Order getOrderById(int id) {
        Order order = new Order();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id,ordertime,price,state,user_id FROM 'order' WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setOrdertime(rs.getDate("ordertime"));
                order.setPrice(rs.getDouble("price"));
                order.setState(rs.getBoolean("state"));
                order.setUser_id(rs.getInt("user_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return order;
    }

    @Override
    public int addOrder(Date ordertime, double price, boolean state, int user_id) {
        int order_id = -1;
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        java.sql.Date sqlDate = new java.sql.Date(ordertime.getTime());

        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO 'order'(ordertime,price,state,user_id) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            ps.setDouble(2, price);
            ps.setBoolean(3, state);
            ps.setInt(4, user_id);
            if (ps.executeUpdate() <= 0)
                return -1;

            order_id = ps.getGeneratedKeys().getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return order_id;

    }

    @Override
    public boolean updateOrderState(boolean state, int order_id) {
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE 'order' SET state = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, state);
            ps.setInt(2,order_id);
            if(ps.executeUpdate() <= 0)
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return true;

    }
}
