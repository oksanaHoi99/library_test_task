package data.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FilterBooksTest extends BaseTest {
    @BeforeMethod
    public void addBookToLibrary() {
        lm.addBook(book1);
        lm.addBook(book2);
        lm.addBook(book3);
        lm.addBook(book4);
        lm.addBook(book5);
    }

    @Test
    public void filterBooksByAuthorTest() {
        assertThat(lm.filterBooksByAuthor(authorForFilters).size(), is(2));
        assertThat((int) lm.filterBooksByAuthor(authorForFilters).stream()
                .filter(book -> book.getAuthor().equals(authorForFilters)).count(), is(2));
    }

    @Test
    public void filterBooksByTitleTest() {
        assertThat(lm.filterBooksByTitle(titleForFilter).size(), is(1));
        assertThat((int) lm.filterBooksByTitle(titleForFilter).stream()
                .filter(book -> book.getTitle().contains(titleForFilter)).count(), is(1));
    }
}
