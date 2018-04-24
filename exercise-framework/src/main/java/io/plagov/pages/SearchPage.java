package io.plagov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends AbstractPage {

    @FindBy(id = "ptxt")
    private WebElement searchText;

    @FindBy(name = "topt[8][min]")
    private WebElement minPrice;

    @FindBy(name = "topt[8][max]")
    private WebElement maxPrice;

    @FindBy(name = "sid")
    private WebElement subheading;

    @FindBy(id = "s_region_select")
    private WebElement region;

    @FindBy(name = "pr")
    private WebElement period;

    @FindBy(name = "sort")
    private WebElement sorting;

    @FindBy(id = "sbtn")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage typeTextForSearch(String textForSearch) {
        searchText.sendKeys(textForSearch);
        return this;
    }

    public SearchPage setMinPrice(String minPriceAmount) {
        minPrice.sendKeys(minPriceAmount);
        return this;
    }

    public SearchPage setMaxPrice(String maxPriceAmount) {
        maxPrice.sendKeys(maxPriceAmount);
        return this;
    }

    public SearchPage selectSubheading(String subheadingOption) {
        Select subheadingDropdown = new Select(subheading);
        subheadingDropdown.selectByVisibleText(subheadingOption);
        return this;
    }

    public SearchPage selectRegion(String regionOption) {
        Select regionDropdown = new Select(region);
        regionDropdown.selectByVisibleText(regionOption);
        return this;
    }

    public SearchPage selectPeriod(String periodOption) {
        Select periodDropdown = new Select(period);
        periodDropdown.selectByVisibleText(periodOption);
        return this;
    }

    public SearchPage sortBy(String sortOption) {
        Select sortDropdown = new Select(sorting);
        sortDropdown.selectByVisibleText(sortOption);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.submit();
        return new SearchResultsPage(getDriver());
    }
}
