package ua.page_object_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends  Page{

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get("http://localhost/litecart/en/");
        return this;
    }

    @FindBy(xpath=".//*[@id='box-most-popular']//a")
    public WebElement firstRandomGoods;

    @FindBy(xpath = ".//*[@id='cart']/a[@class='link']")
    public WebElement checkoutButton;

}
