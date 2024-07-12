package data.tests;


import net.datafaker.Faker;
import org.bookLibrary.Author;
import org.bookLibrary.Book;
import org.bookLibrary.LibraryManagementImplementation;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected Map<Integer, Book> books = new HashMap<>();
    protected Book book1;
    protected Book book2;
    protected Book book3;
    protected Book book4;
    protected Book book5;
    protected Author authorForFilters;
    protected String titleForFilter;
    protected LibraryManagementImplementation lm;
    protected String detailForUpdate;
    private Faker faker;

    @BeforeClass
    public void setUp() {
        faker = new Faker();

        detailForUpdate = faker.book().genre();

        lm = new LibraryManagementImplementation(books);

        authorForFilters = Author.builder()
                .fullName(faker.book().author())
                .build();

        titleForFilter = faker.book().title();

        book1 = Book.builder()
                .title(faker.book().title())
                .author(Author.builder()
                        .fullName(faker.book().author())
                        .build())
                .details(faker.book().genre())
                .build();

        book2 = Book.builder()
                .title(titleForFilter)
                .author(authorForFilters)
                .details(faker.book().genre())
                .build();

        book3 = Book.builder()
                .title(faker.book().title())
                .author(Author.builder()
                        .fullName(faker.book().author())
                        .build())
                .details(faker.book().genre())
                .build();

        book4 = Book.builder()
                .title(faker.book().title())
                .author(Author.builder()
                        .fullName(faker.book().author())
                        .build())
                .details(faker.book().genre())
                .build();

        book5 = Book.builder()
                .title(faker.book().title())
                .author(authorForFilters)
                .details(faker.book().genre())
                .build();
    }
}
