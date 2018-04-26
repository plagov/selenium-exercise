package io.plagov.bookmarks;

import io.plagov.driver.Browser;
import io.plagov.pages.BookmarksPage;
import io.plagov.pages.HomePage;
import io.plagov.pages.SearchResultsPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckRandomlySelectedBookmarksTest extends Browser {

    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private HomePage homePage = new HomePage(driver);
    private BookmarksPage bookmarksPage = new BookmarksPage(driver);

    private String textToSearch = "Компьютер";
    private String region = "Рига";
    private String dealType = "Продажа";
    private String minPrice = "0";
    private String maxPrice = "300";
    private String period = "За последний месяц";
    private int numberOfSearchResults = 3;

    @Test
    public void myAnnouncements() {

        searchResultsPage = homePage.openHomePage()
            .switchLanguage()
            .openElectronicsPage()
            .openSearchPage()
            .typeTextForSearch(textToSearch)
            .selectRegion(region)
            .clickSearchButton()
            .sortResultsByPrice()
            .filterDealByType(dealType)
            .openAdvancedSearch()
            .setMinPrice(minPrice)
            .setMaxPrice(maxPrice)
            .selectPeriod(period)
            .clickSearchButton()
            .selectRandomSearchResults(numberOfSearchResults)
            .addToBookmarks();
        searchResultsPage.openBookmarksPage()
            .getIdsOfBookmarkItems();

        int numberOfBookmarks = bookmarksPage.getIdsOfBookmarkItems().size();
        int numberOfSelectedItems = searchResultsPage.getRandomSearchResults().size();

        assertEquals(numberOfSelectedItems, numberOfBookmarks);
    }
}
