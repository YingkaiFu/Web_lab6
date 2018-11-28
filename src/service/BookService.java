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
}
