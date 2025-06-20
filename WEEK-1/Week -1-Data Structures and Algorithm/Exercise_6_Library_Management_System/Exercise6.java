package Exercise_6_Library_Management_System;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title.toLowerCase();  // Normalize case
        this.author = author;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class LibraryManagement {

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
        title = title.toLowerCase();  // Normalize case

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareTo(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, Comparator.comparing(book -> book.title));
    }

    public static void displayBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book(101, "Data Structures", "Mark Allen");
        books[1] = new Book(102, "Algorithms", "Cormen");
        books[2] = new Book(103, "Operating Systems", "Silberschatz");
        books[3] = new Book(104, "Computer Networks", "Tanenbaum");

        System.out.println("All Books:");
        LibraryManagement.displayBooks(books);

        System.out.println("\nLinear Search for 'Algorithms':");
        Book result1 = LibraryManagement.linearSearch(books, "Algorithms");
        System.out.println(result1 != null ? result1 : "Book not found.");

        LibraryManagement.sortBooksByTitle(books); // Must sort first
        System.out.println("\nBinary Search for 'Operating Systems':");
        Book result2 = LibraryManagement.binarySearch(books, "Operating Systems");
        System.out.println(result2 != null ? result2 : "Book not found.");
    }
}

