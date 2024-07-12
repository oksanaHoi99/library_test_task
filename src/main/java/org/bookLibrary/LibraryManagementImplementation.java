package org.bookLibrary;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LibraryManagementImplementation implements LibraryManagement {
    private Map<Integer, Book> books = new HashMap<>();

    public LibraryManagementImplementation(Map<Integer, Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (!books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public void deleteBook(Book book) {
        books.remove(book.getId());
    }

    public void updateDetails(Book book, String newDetails) {
         Book bookToBeUpdated = books.values().stream()
                .filter(bookValue -> book.getId() == bookValue.getId())
                .findFirst().orElseThrow();
         bookToBeUpdated.setDetails(newDetails);
    }

    public List<Book> filterBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksByAuthor(Author author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().getFullName().contains(author.getFullName()))
                .collect(Collectors.toList());
    }

    public void deleteAuthorBooks(Author author) {
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)){
                books.remove(book.getId());
            }
        }
    }

    public void exportBooksToCsvFile() {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter("books.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(books.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
