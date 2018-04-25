package io.plagov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"main_table\"]/span[2]/b[3]/a")
    private WebElement searchMenu;

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage openElectronicsSearchPage() {
        searchMenu.click();
        return new SearchPage(getDriver());
    }
}
