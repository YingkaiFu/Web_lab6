package vo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void add(Book book) {
        bookList.add(book);
    }
}
