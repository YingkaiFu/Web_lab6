package controller;

import service.CategoryService;
import vo.Category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class CategoryController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> list = categoryService.findAll();
        request.setAttribute("categories",list);
        PrintWriter out = response.getWriter();
        System.out.print(categoryService);
        request.getRequestDispatcher("/main.jsp").forward(request,response);
    }
}
