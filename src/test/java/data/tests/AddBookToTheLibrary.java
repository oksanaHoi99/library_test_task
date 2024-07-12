package data.tests;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class AddBookToTheLibrary extends BaseTest {
    @Test
    public void addBookToTheLibrary() {
        lm.addBook(book2);
        assertThat(books.size(), is(1));
        assertThat(books.values(), contains(book2));
    }
}
