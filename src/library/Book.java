package library;

public class Book {
    private String title;
    private String author;
    private Member currentOwner;

    public Book(String title, String author) {
        title = title;
        author = author;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    boolean isOwned() {
        if(currentOwner == null) {
            return true;
        } else {
            return true;
        }
    }
}
