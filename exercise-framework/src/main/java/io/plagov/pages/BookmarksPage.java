package io.plagov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BookmarksPage extends AbstractPage {

    @FindBy(id = "filter_frm")
    private WebElement bookmarksTable;

    public BookmarksPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> bookmarkItems = new ArrayList<>();
    private List<String> idOfBookmarkItems = new ArrayList<>();

    private List<WebElement> getBookmarkItems() {
        try {
            bookmarkItems = bookmarksTable.findElements(By.xpath("//*[starts-with(@id, 'tr_')]"));
        } catch (NullPointerException npe) {
            npe.getStackTrace();
        }
        return bookmarkItems;
    }

    public List<String> getIdsOfBookmarkItems() {
        for (WebElement webElement : getBookmarkItems()) {
            String id = webElement.getAttribute("id");
            idOfBookmarkItems.add(id);
        }
        return idOfBookmarkItems;
    }

}
