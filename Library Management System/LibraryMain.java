import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String author;
    private String title;
    private boolean isIssued;
    private String bookType;

    public Book(int bookId, String author, String title, boolean isIssued, String bookType) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.isIssued = isIssued;
        this.bookType = bookType;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getbookType() {
        return bookType;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

}

class EBook extends Book {
    private int fileSize;
    private String format;

    public EBook(int bookId, String author, String title, boolean isIssued, int fileSize, String format,
            String bookType) {
        super(bookId, author, title, isIssued, bookType);
        this.fileSize = fileSize;
        this.format = format;
    }
}

class PrintedBook extends Book {
    private int pageSize;
    private String shelfLocation;

    public PrintedBook(int bookId, String author, String title, boolean isIssued, int pageSize, String shelfLocation,
            String bookType) {
        super(bookId, author, title, isIssued, bookType);
        this.pageSize = pageSize;
        this.shelfLocation = shelfLocation;
    }
}

class LibraryManager {
    private List<Book> bookList = new ArrayList<>();
    private List<Book> issuedBooks = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void returnBook(Book book) {
        bookList.remove(book);
    }

    public void issueBook(int bookId) {
        for (Book b : bookList) {
            if (b.getBookId() == bookId) {
                if (!b.isIssued()) {
                    b.setIssued(true);
                    issuedBooks.add(b);
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book already issued.");

                }
            }
        }
    }

    public void printIssuedBooks() {
        System.out.println("*******Issued BookList******");
        for (Book b : issuedBooks) {
            System.out.println("Book Id : " + b.getBookId());
            System.out.println("Author : " + b.getAuthor());
            System.out.println("Book Type : " + b.getbookType());
            System.out.println("");
            System.out.println("");
        }
    }

    public void takeIssuedBook(Book book) {
        book.setIssued(false);
        issuedBooks.remove(book);
    }

    public void printBookList() {
        System.out.println("*******BookList******");
        for (Book b : bookList) {
            System.out.println("Book Id : " + b.getBookId());
            System.out.println("Author : " + b.getAuthor());
            System.out.println("Availability : " + (b.isIssued() ? "Not Available" : "Available"));
            System.out.println("Book Type : " + b.getbookType());
            System.out.println("");
            System.out.println("");
        }
    }
}

public abstract class LibraryMain {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        library.addBook(new EBook(1, "Garvit", "Learn Java", false, 10, "pdf", "eBook"));
        library.addBook(new PrintedBook(2, "Jahnvi", "Learn Chess", false, 120, "rightShelf", "Printed"));

        library.issueBook(2);
        library.printBookList();
        library.printIssuedBooks();

    }

}