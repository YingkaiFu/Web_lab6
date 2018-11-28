package dao.impl;

import dao.CategoryDao;
import dao.JDBCUtil;
import vo.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public void add(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public List<Category> findAll() {
        Connection connection = null;
        Statement stat = null;
        List<Category> list = new ArrayList<Category>();
        try {
            connection = JDBCUtil.getConnection();
            stat = (Statement)connection.createStatement();
            String sql = "select id,name,description from category";
            ResultSet resultSet = (ResultSet)stat.executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeConnection(connection);
        }
        return list;
    }

}
