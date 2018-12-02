package dao.impl;


import dao.BookDao;
import dao.JDBCUtil;
import vo.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBookByCategory(int category_id) {
        List<Book> list = new ArrayList<Book>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,author,price,image,description,category_id from book where category_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,category_id);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setImage(rs.getString("image"));
                book.setDescription(rs.getString("description"));
                book.setCategory_id(rs.getString("category_id"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        return list;
    }

    @Override
    public Book getBookById(int id) {
        Book book = new Book();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,author,price,image,description,category_id from book where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setImage(rs.getString("image"));
                book.setDescription(rs.getString("description"));
                book.setCategory_id(rs.getString("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return book;
    }

//    其他方法
}
