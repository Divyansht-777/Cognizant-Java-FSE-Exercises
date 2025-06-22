import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibrarySystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Hobbit", "J.R.R. Tolkien"),
            new Book(2, "Pride and Prejudice", "Jane Austen"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "To Kill a Mockingbird", "Harper Lee"),
            new Book(5, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        System.out.println("Linear Search:");
        Book foundLinear = linearSearch(books, "1984");
        System.out.println(foundLinear != null ? foundLinear : "Book not found.");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\nBinary Search (after sorting):");
        Book foundBinary = binarySearch(books, "1984");
        System.out.println(foundBinary != null ? foundBinary : "Book not found.");
    }
}

