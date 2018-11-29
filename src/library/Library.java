package library;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    List<Book> books;
    List<Member> members;

    /**
     * Returns all book titles that belong to the library.
     * @return book titles list.
     */
    public List<String> getAllBookTitles() {
        List<String> books = new ArrayList<>();
        for(Book book: this.books) {
            books.add(book.getTitle());
        }
        return books;
    }

    /**
     * Gives all book titles that can be borrowed.
     * @return borrowable book titles list.
     */
    public List<String> getAllAvailableBookTitles() {
        List<String> books = new ArrayList<>();
        for(Book book: this.books) {
            if(!book.isOwned()) {
                books.add(book.getTitle());
            }
        }
        return books;
    }

    /**
     * Gives a list of pairs with the number of books of each author in the library.
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
     * Allows a user to return a book to the library
     * @param bookTitle title of the book being returned.
     * @param currentOwner current owner of the book.
     */
    public void returnBookToLibrary(String bookTitle, String currentOwner) {

    }
}
