package io.plagov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SearchResultsPage extends AbstractPage {

    @FindBy(id = "a_fav_sel")
    private WebElement bookmarksAdd;

    @FindBy(name = "sid")
    private WebElement typeOfDeal;

    @FindBy(xpath = "//*[@id=\"page_main\"]/tbody/tr/td/table[1]/tbody/tr/td[4]/a")
    private WebElement advancedSearch;

    @FindBy(xpath = "//*[@id=\"page_main\"]/tbody/tr/td/table[2]/tbody")
    private WebElement searchResultsTable;

    private List<WebElement> searchResultsRows;

    private List<WebElement> searchResultsRows() {
        try {
            searchResultsRows = searchResultsTable.findElements(By.tagName("tr"));
        } catch (NullPointerException npe) {
            npe.getStackTrace();
        }
        return searchResultsRows;
    }

    @FindBy(xpath = "//*[@id=\"head_line\"]/td[2]/noindex/a")
    private WebElement priceSortColumn;

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

    private List<WebElement> getSearchResultsRows() {
        if (!searchResultsRows().isEmpty()) {
            return searchResultsRows();
        } else {
            return Collections.emptyList();
        }
    }

    public SearchResultsPage selectRandomSearchResults(int announcementsToSelect) {

        Random random = new Random();
        List<WebElement> randomSearchResults = new ArrayList<>();

        for (int i = 1; i <= announcementsToSelect; i++) {
            int pick = random.nextInt(getSearchResultsRows().size());
            randomSearchResults.add(getSearchResultsRows().get(pick));
        }

        for (WebElement randomResult : randomSearchResults) {
            randomResult.findElement(By.tagName("input")).click();
        }

        return this;
    }

    public SearchResultsPage sortResultsByPrice() {
        priceSortColumn.click();
        return this;
    }

}
