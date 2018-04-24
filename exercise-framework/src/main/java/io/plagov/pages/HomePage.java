package io.plagov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    private String url = "https://www.ss.com";
    private String title = "Sludinājumi - SS.COM";

    @FindBy(xpath = "//*[@id=\"main_table\"]/span[4]/a")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"main_img_div\"]/div[1]/div/h2/a")
    private WebElement electronicsSection;

    @FindBy(xpath = "/html/body/div[1]/div/span[2]/span/b/a")
    private WebElement bookmarks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        getDriver().get(url);
        return this;
    }

    public boolean isAtHomePage() {
        return getDriver().getTitle().equals(title);
    }

    public HomePage switchLanguage() {
        languageButton.click();
        return this;
    }

    public HomePage openBookmarks() {
        bookmarks.click();
        return this;
    }

    public ElectronicsPage openElectronicsPage() {
        electronicsSection.click();
        return new ElectronicsPage(getDriver());
    }

}
