package vo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> bookList;

    public Cart() {
        bookList = new ArrayList<>();
    }

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
