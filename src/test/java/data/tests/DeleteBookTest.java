package data.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;
import static org.hamcrest.Matchers.is;

public class DeleteBookTest extends BaseTest {
    @BeforeMethod
    public void addBookToLibrary() {
        lm.addBook(book1);
        lm.addBook(book2);
        lm.addBook(book3);
    }

    @Test
    public void deleteBookFromLibraryWithCorrectDetails() {
        lm.deleteBook(book1);
        assertFalse(books.values().contains(book1));
    }

    @Test
    public void deleteBookForAuthor() {
        lm.deleteAuthorBooks(authorForFilters);
        assertThat((int) books.values().stream().filter(book -> book.getAuthor().equals(authorForFilters)).count(), is(0));
    }
}
