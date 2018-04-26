package io.plagov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchResultsPage extends AbstractPage {

    @FindBy(id = "a_fav_sel")
    private WebElement bookmarksAdd;

    @FindBy(name = "sid")
    private WebElement typeOfDeal;

    @FindBy(xpath = "//*[@id=\"page_main\"]/tbody/tr/td/table[1]/tbody/tr/td[4]/a")
    private WebElement advancedSearch;

    @FindBy(id = "page_main")
    private WebElement searchResultsTable;

    private List<WebElement> searchResultsRows;

    private List<WebElement> getSearchResultsRows() {
        try {
            searchResultsRows = searchResultsTable.findElements(By.cssSelector("tr[style=\"cursor: pointer;\"]"));
        } catch (NullPointerException npe) {
            npe.getStackTrace();
        }
        return searchResultsRows;
    }

    @FindBy(xpath = "//*[@id=\"head_line\"]/td[2]/noindex/a")
    private WebElement priceSortColumn;

    @FindBy(xpath = "//*[@id=\"main_table\"]/span[2]/span/b/a")
    private WebElement bookmarksPage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage addToBookmarks() {
        bookmarksAdd.click();
        return this;
    }

    public SearchResultsPage filterDealByType(String typeOfDealOption) {
        Select typeOfDealDropdown = new Select(typeOfDeal);
        typeOfDealDropdown.selectByVisibleText(typeOfDealOption);
        return this;
    }

    public SearchPage openAdvancedSearch() {
        advancedSearch.click();
        return new SearchPage(getDriver());
    }

    private List<WebElement> randomSearchResults = new ArrayList<>();

    public List<WebElement> getRandomSearchResults() {
        return this.randomSearchResults;
    }

    private void generateRandomSearchResults(int announcementsToSelect) {
        Random random = new Random();
        for (int i = 0; i < announcementsToSelect; i++) {
            int pick = random.nextInt(getSearchResultsRows().size());
            randomSearchResults.add(getSearchResultsRows().get(pick));
        }
    }

    public SearchResultsPage selectRandomSearchResults(int numbersToClick) {
        generateRandomSearchResults(numbersToClick);
        for (WebElement randomResult : randomSearchResults) {
            randomResult.findElement(By.tagName("input")).click();
        }
        return this;
    }

    public SearchResultsPage sortResultsByPrice() {
        priceSortColumn.click();
        return this;
    }

    public BookmarksPage openBookmarksPage() {
        bookmarksPage.click();
        return new BookmarksPage(getDriver());
    }

}
