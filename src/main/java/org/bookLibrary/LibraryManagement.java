package org.bookLibrary;

import java.util.List;
import java.util.Map;

public interface LibraryManagement {

    void addBook(Book book);
    List<Book> getAllBooks();

    void deleteBook(Book book);

    void updateDetails(Book book, String newDetails);

    List<Book> filterBooksByTitle(String title);

    List<Book> filterBooksByAuthor(Author author);

    void deleteAuthorBooks(Author author);
}
