package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import vo.Book;

import java.util.List;

public class BookService {
    private BookDao book = new BookDaoImpl();
    public List<Book> getBookByCategoryID(int id) {
        return book.getBookByCategory(id);
    }

    public Book getBookById(int id) {
        return book.getBookById(id);
    }
    public boolean addBook(String bookname,String author,int price,String image,String remark,int category_id) {
        return book.addBook(bookname,author,price,image,remark,category_id);
    }
}
