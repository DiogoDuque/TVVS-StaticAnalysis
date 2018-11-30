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
        Menu borrowMenu = new Menu("Empréstimos", new ArrayList<>(Arrays.asList(
                new MenuItem("Pedir livro emprestado", () -> {
                    String memberName = Misc.readInput("Qual o nome do membro a quem emprestar?");
                    String bookTitle = Misc.readInput("Qual o título do livro?");
                    lib.borrowBook(bookTitle, memberName);
        }),
                new MenuItem("Devolver livro emprestado", () -> {
                    String memberName = Misc.readInput("Qual o nome do membro a que devolve?");
                    String bookTitle = Misc.readInput("Qual o título do livro?");
                    lib.returnBookToLibrary(bookTitle, memberName);
                })
        )));

        Menu memberMenu = new Menu("Membros", new ArrayList<>(Arrays.asList(
                new MenuItem("Ver todos os membros", () -> showList(lib.getAllMembersNames())),
                new MenuItem("Ver quantidade de livros emprestados a cada membro", () -> {
                    List<Pair<String, Integer>> borrowedBooksPairs = lib.getBorrowedBookCountByMember();
                    List<String> borrowedBooksCountList = new ArrayList<>();
                    for(Pair<String, Integer> pair: borrowedBooksPairs) {
                        borrowedBooksCountList.add(pair.getKey()+": "+pair.getValue());
                    }
                    showList(borrowedBooksCountList);
                })
        )));

        Menu booksMenu = new Menu("Livros", new ArrayList<>(Arrays.asList(
                new MenuItem("Ver todos os livros", () -> showList(lib.getAllBooks())),
                new MenuItem("Ver livros disponíveis para empréstimo", () -> showList(lib.getAllAvailableBookTitles())),
                new MenuItem("Ver quantidade de livros escritos por cada autor", () -> {
                    List<Pair<String, Integer>> authorCountPairs = lib.getAuthorBookCount();
                    List<String> authorCountList = new ArrayList<>();
                    for(Pair<String, Integer> pair: authorCountPairs) {
                        authorCountList.add(pair.getKey()+": "+pair.getValue());
                    }
                    showList(authorCountList);
                })
        )));

        return new Menu("Biblioteca", new ArrayList<>(Arrays.asList(
                new MenuItem("Livros", booksMenu::showMenu),
                new MenuItem("Membros", memberMenu::showMenu),
                new MenuItem("Empréstimos", borrowMenu::showMenu)
        )));
    }

}
