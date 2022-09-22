package tests;

import com.codeborne.selenide.Selenide;
import configs.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

/*
    1. Open books page
    2. Put unsorted prices to the list
    3. Select Low to High in Sort by dropdown
    4. Assert sorted and unsorted lists
 */

public class SortBooksByPrice extends BaseTest{

    BooksPage booksPage = new BooksPage();

    @Test
    public void sortBooksLowToHigh(){
        open(Config.getBooks());
        List<Float> sorted = booksPage.getBookPrices().stream().sorted().collect(Collectors.toList());
        booksPage.selectLowToHigh();
        booksPage.getBookPrices();
        Assert.assertEquals(booksPage.getBookPrices(), sorted, "Prices not sorted low to high");
    }
}
