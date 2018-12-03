package dao;
import vo.Category;

import java.util.List;

public interface CategoryDao {
    void add(Category category);

    void delete(Category category);

    List<Category> findAll();

}
