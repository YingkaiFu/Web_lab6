package dao.impl;

import dao.JDBCUtil;
import dao.UserDao;
import vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String id, String password) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select username from user where username = ? and password= ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return status;
    }

    @Override
    public boolean logup(String id, String password, String phone, String tel, String email, String add) {
        boolean status = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select username from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                sql = "INSERT into user(username,password,phone,cellphone,email,address) values (?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, phone);
                preparedStatement.setString(4, tel);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, add);
                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    status = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return status;
    }

    @Override
    public List<User> queryAll(){

        List<User> list=new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,username,phone,cellphone,email,address from user ";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                user.setCellphone(rs.getString("cellphone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));

                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return list;
    }
}
