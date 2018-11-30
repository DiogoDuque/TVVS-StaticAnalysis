package library;

import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBookFromLibrary(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBorrowedBookToLibrary(Book book) {
        borrowedBooks.remove(book);
    }

    public List<String> getBorrowedBooksList() {
        List<String> books = new ArrayList<>();
        for(Book book: borrowedBooks) {
            books.add(book.toString());
        }
        return books;
    }
}
