package Week1.DataStructures.Exercise6;
import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class Exercise6 {

    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search using Comparator
    public static Book binarySearch(List<Book> books, String title) {
        // Sort using Comparator by title
        books.sort(Comparator.comparing(b -> b.title.toLowerCase()));

        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Book midBook = books.get(mid);
            int cmp = midBook.title.compareToIgnoreCase(title);

            if (cmp == 0) return midBook;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.add(new Book(3, "1984", "George Orwell"));
        library.add(new Book(4, "Sapiens", "Yuval Noah Harari"));

        System.out.println("Linear Search for 'Sapiens':");
        Book result1 = linearSearch(library, "Sapiens");
        System.out.println(result1 != null ? result1 : "Book not found");

        System.out.println("\nBinary Search for '1984':");
        Book result2 = binarySearch(library, "1984");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
