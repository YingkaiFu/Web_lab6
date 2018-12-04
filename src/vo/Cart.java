package vo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> bookList = new ArrayList<>();

    public List<CartItem> getBookList() {
        return bookList;
    }

    public void setBookList(List<CartItem> bookList) {
        this.bookList = bookList;
    }

    public void add(CartItem book) {
        bookList.add(book);
    }
}
