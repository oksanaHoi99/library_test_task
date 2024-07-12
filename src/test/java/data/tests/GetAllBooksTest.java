package data.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetAllBooksTest extends BaseTest {
    @BeforeMethod
    public void addBooksToLibrary() {
        lm.addBook(book1);
        lm.addBook(book2);
        lm.addBook(book3);
        lm.addBook(book4);
    }

    @Test
    public void getAllBooksTest() {
        assertThat(lm.getAllBooks().size(), is(4));
    }
}
