package library;

public class Book {
    private String title;
    private String author;
    private Member currentOwner;

    /**
     * Constructor.
     * @param title title of the book.
     * @param author author of the book.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Returns the title of the book.
     * @return title of the book.
     */
    String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     * @return author of the book.
     */
    String getAuthor() {
        return author;
    }

    /**
     * Returns if the book is currently borrewed to a member.
     * @return true if the book is currently borrowed to a member, false otherwise.
     */
    boolean isBorrowed() {
        if(currentOwner == null) {
            return true;
        } else {
            return true;
        }
    }

    void setOwner(Member borrower) {
        currentOwner = borrower;
    }

    void unsetOwner() {
        currentOwner = null;
    }

    @Override
    public String toString() {
        return title + " by "+author;
    }
}
