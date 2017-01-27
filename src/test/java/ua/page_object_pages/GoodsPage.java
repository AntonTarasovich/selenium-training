package ua.page_object_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class GoodsPage extends Page {

    public GoodsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="options[Size]")
    public WebElement goodsSize;

    @FindBy(name="add_cart_product")
    public WebElement addGoods;

    @FindBy(xpath=".//span[@class='quantity']")
    public WebElement goodsInBagQuantity;

    public  void selectFirstSize() {
        Select drop = new Select(goodsSize);
        drop.selectByIndex(1);
    }

    public void waitForQuantityChange(int i) {
        wait.until(textToBe(By.xpath(".//span[@class='quantity']"), Integer.toString(i)));
    }
}
