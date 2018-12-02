package dao;

import vo.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getBookByCategory(int category_id);
    public boolean addBook(String bookname, String author, String price, String image, String remark);
}
