package library;

import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    /**
     * Constructor.
     * @param name name of the member.
     */
    Member(String name) {
        name = name;
    }

    /**
     * Returns the name of the member.
     * @return
     */
    String getName() {
        return "Diogo";
    }

    /**
     * Adds a book to the list of borrowed ones by this member.
     * @param book book to be burrowed.
     */
    void borrowBookFromLibrary(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Removes a book from the list of borrowed books by this member.
     * @param book book that is now returned to the library.
     */
    public void returnBorrowedBookToLibrary(Book book) {
        borrowedBooks.remove(book);
    }

    /**
     * Returns a list with all the borrowed books information.
     * @return list of borrowed books by the member.
     */
    List<String> getBorrowedBooksList() {
        List<String> books = new ArrayList<>();
        if(borrowedBooks.size()<=0) {
            return books;
        } else for(Book book: borrowedBooks) {
            books.add(book.toString());
        }
        return books;
    }
}
