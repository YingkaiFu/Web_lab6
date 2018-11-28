package service;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import vo.Category;

import java.util.List;

public class CategoryService {
    private CategoryDao category = new CategoryDaoImpl();

    public List<Category> findAll() {
        return category.findAll();
    }

}
