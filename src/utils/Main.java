package utils;

import javafx.util.Pair;
import library.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Menu.showList;

public class Main {

    public static void main(String[] args) {
        Library lib = new Library();
        setupLibrary(lib);

        Menu mainMenu = setupMenus(lib);
        mainMenu.showMenu();
    }

    private static void setupLibrary(Library lib) {
        lib.addMember("Hélder");
        lib.addMember("Diogo");
        lib.addBook("1984", "George Orwell");
        lib.addBook("Gulliver's Travels", "Jonathan Swift");
        lib.addBook("Harry Potter and The Philosopher's Stone", "J. K. Rowling");
        lib.addBook("Harry Potter and the Chamber of Secrets", "J. K. Rowling");
        lib.addBook("Hitchiker's Guide to The Galaxy", "Douglas Adams");
        lib.addBook("The Little Prince", "Antoine de Saint-Exupéry");
    }

    private static Menu setupMenus(Library lib) {
        Menu borrowMenu = new Menu("Borrowing/returning books", new ArrayList<>(Arrays.asList(
                new MenuItem("Borrow a book", () -> {
                    String memberName = Misc.readInput("Member's name:");
                    String bookTitle = Misc.readInput("Book title:");
                    lib.borrowBook(bookTitle, memberName);
        }),
                new MenuItem("Return a book", () -> {
                    String memberName = Misc.readInput("Member's name:");
                    String bookTitle = Misc.readInput("Book title:");
                    lib.returnBookToLibrary(bookTitle, memberName);
                })
        )));

        Menu memberMenu = new Menu("Members", new ArrayList<>(Arrays.asList(
                new MenuItem("See all members", () -> showList(lib.getAllMembersNames())),
                new MenuItem("See how many books each member currently has", () -> {
                    List<Pair<String, Integer>> borrowedBooksPairs = lib.getBorrowedBookCountByMember();
                    List<String> borrowedBooksCountList = new ArrayList<>();
                    for(Pair<String, Integer> pair: borrowedBooksPairs) {
                        borrowedBooksCountList.add(pair.getKey()+": "+pair.getValue());
                    }
                    showList(borrowedBooksCountList);
                })
        )));

        Menu booksMenu = new Menu("Books", new ArrayList<>(Arrays.asList(
                new MenuItem("See all books", () -> showList(lib.getAllBooks())),
                new MenuItem("See available books", () -> showList(lib.getAllAvailableBookTitles())),
                new MenuItem("See how many books of each author exist", () -> {
                    List<Pair<String, Integer>> authorCountPairs = lib.getAuthorBookCount();
                    List<String> authorCountList = new ArrayList<>();
                    for(Pair<String, Integer> pair: authorCountPairs) {
                        authorCountList.add(pair.getKey()+": "+pair.getValue());
                    }
                    showList(authorCountList);
                })
        )));

        return new Menu("Library", new ArrayList<>(Arrays.asList(
                new MenuItem("Books Menu", booksMenu::showMenu),
                new MenuItem("Members Menu", memberMenu::showMenu),
                new MenuItem("Borrow & Return Menu", borrowMenu::showMenu)
        )));
    }

}
