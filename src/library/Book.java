package library;

public class Book {
    private String title;
    private String author;
    private Member currentOwner;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
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

    public void setOwner(Member borrower) {
        currentOwner = borrower;
    }

    @Override
    public String toString() {
        return title + " by "+author;
    }
}
