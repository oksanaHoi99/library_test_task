package data.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateLibraryTests extends BaseTest {
    @BeforeMethod
    public void addBookToLibrary() {
        lm.addBook(book1);
        lm.addBook(book2);
        lm.addBook(book3);
    }

    @Test
    public void updateLibraryWithCorrectDetails() {
        lm.updateDetails(book1, detailForUpdate);
        assertThat(book1.getDetails(), equalTo(detailForUpdate));
    }
}
