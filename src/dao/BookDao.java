package dao;

import vo.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBookByCategory(int category_id);

    Book getBookById(int id);
    boolean addBook(String bookname, String author, int price, String image, String remark);
}
