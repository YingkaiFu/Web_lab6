package dao;
import vo.Category;

import java.util.List;

public interface CategoryDao {
    public void add(Category category);

    public void delete(Category category);

    public List<Category> findAll();

}
