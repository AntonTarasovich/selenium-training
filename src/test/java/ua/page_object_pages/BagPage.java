package ua.page_object_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class BagPage extends Page{

    public BagPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BagPage open() {
        driver.get("http://localhost/litecart/en/checkout");
        return this;
    }

    @FindBy(css = ".dataTable .item")
    public List<WebElement> itemTypesQuantity;

    @FindBy(name = "quantity")
    public WebElement goodsQuantity;

    @FindBy(name = "remove_cart_item")
    public WebElement removeGoods;

    @FindBy(css = ".dataTable")
    public WebElement footerTable;

    @FindBy(tagName = "em")
    public WebElement emptyBagMessage;

    public void tableColumnDisappear(WebElement element) {
        wait.until(stalenessOf(element));
    }
}
