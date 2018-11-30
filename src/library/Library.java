package library;

import javafx.util.Pair;
import utils.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    /**
     * Adds a book to the library.
     * @param title title of the book.
     * @param author author of the book.
     */
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    /**
     * Adds a new member to the library.
     * @param name name of the member.
     */
    public void addMember(String name) {
        members.add(new Member(name));
    }

    /**
     * Returns all book titles that belong to the library.
     * @return book titles list.
     */
    public List<String> getAllBooks() {
        List<String> books = new ArrayList<>();
        for(Book book: this.books) {
            books.add(book.toString());
        }
        return books;
    }

    /**
     * Returns all book titles that can be borrowed.
     * @return borrowable book titles list.
     */
    public List<String> getAllAvailableBookTitles() {
        List<String> availableBooks = new ArrayList<>();
        for(Book book: this.books) {
            if(!book.isBorrowed()) {
                availableBooks.add(book.getTitle());
            }
        }
        return availableBooks;
    }

    /**
     * Returns a list of pairs with the number of books of each author in the library.
     * @return list of pairs<authorName, authorBooksCount>.
     */
    public List<Pair<String, Integer>> getAuthorBookCount() {
        List<Pair<String, Integer>> authorBookCount = new ArrayList<>();
        HashMap<String, Integer> authorCountMap = new HashMap<>();
        for(Book book: books) {
            String author = book.getAuthor();
            if(authorCountMap.containsKey(author)) {
                int current_count = authorCountMap.get(author);
                authorCountMap.put(author, current_count+1);
            } else {
                authorCountMap.put(author, 1);
            }
        }
        for(Map.Entry<String, Integer> mapEntry: authorCountMap.entrySet()) {
            authorBookCount.add(new Pair<>(mapEntry.getKey(), mapEntry.getValue()));
        }
        return authorBookCount;
    }

    /**
     * Allows a user to borrowBookFromLibrary a book from the library.
     * @param bookTitle title of the book being borrowed.
     * @param borrowerName name of the member borrowing this book.
     */
    public void borrowBook(String bookTitle, String borrowerName) {
        Member borrower = null;
        Book bookToBeBurrowed = null;
        for(Member member: members) {
            if(member.getName().equals(borrowerName)) {
                borrower = member;
                break;
            }
        }
        for(Book book: books) {
            if(book.getTitle().equals(bookTitle)) {
                bookToBeBurrowed = book;
                break;
            }
        }
        if(borrower == null || bookToBeBurrowed == null) {
            Misc.waitForKeypress("Invalid parameters... Try again.");
            return;
        }
        borrower.borrowBookFromLibrary(bookToBeBurrowed);
        bookToBeBurrowed.setOwner(borrower);
    }

    /**
     * Allows a user to return a book to the library
     * @param bookTitle title of the book being returned.
     * @param currentOwner current owner of the book.
     */
    public void returnBookToLibrary(String bookTitle, String currentOwner) {
    }

    /**
     * Returns a list with all members registered on the library.
     * @return member list.
     */
    public List<String> getAllMembersNames() {
        List<String> memberNames = new ArrayList<>();
        for(Member member: members) {
            memberNames.add(member.getName());
        }
        return memberNames;
    }

    /**
     * Returns a list of pairs with the number of borrowed books for each member.
     * @return list of pairs<memberName, borrowedBooksCount>
     */
    public List<Pair<String, Integer>> getBorrowedBookCountByMember() {
        List<Pair<String, Integer>> borrowedBookPairs = new ArrayList<>();
        for(Member member: members) {
            int count = member.getBorrowedBooksList().size();
            if(count > 0) {
                borrowedBookPairs.add(new Pair<>(member.getName(), count));
            }
        }
        return borrowedBookPairs;
    }
}
