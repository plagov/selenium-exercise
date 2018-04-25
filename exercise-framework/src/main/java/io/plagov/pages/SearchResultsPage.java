package io.plagov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(id = "a_fav_sel")
    private WebElement bookmarksAdd;

    @FindBy(xpath = "//*[@id=\"page_main\"]/tbody/tr/td/div[2]/span[3]")
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

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage addToBookmarks() {
        bookmarksAdd.click();
        return this;
    }

    public SearchResultsPage selectTypeOfDeal(String typeOfDealOption) {
        Select typeOfDealDropdown = new Select(typeOfDeal);
        typeOfDealDropdown.selectByVisibleText(typeOfDealOption);
        return this;
    }

    public SearchPage openAdvancedSearch() {
        advancedSearch.click();
        return new SearchPage(getDriver());
    }

    public List<WebElement> getSearchResultsRows() {
        // exclude header and footer of a table
        if ((searchResultsRows().size() - 2) > 0) {
            return searchResultsRows();
        } else {
            return Collections.emptyList();
        }
    }

    public SearchResultsPage selectSearchResults(int announcementsToSelect) {
        for (int i = 1; i <= announcementsToSelect; i++) {
            searchResultsRows().get(i).findElement(By.tagName("input")).click();
        }
        return this;
    }

}
