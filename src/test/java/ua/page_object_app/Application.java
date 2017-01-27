package ua.page_object_app;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.page_object_pages.BagPage;
import ua.page_object_pages.GoodsPage;
import ua.page_object_pages.MainPage;

public class Application {

    private WebDriver driver;

    private MainPage mainPage;
    private GoodsPage goodsPage;
    private BagPage bagPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        goodsPage = new GoodsPage(driver);
        bagPage = new BagPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    boolean isElementPresent(WebElement element) {
        try {
            element.getLocation();
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void addGoodsToBag(int goodsQuantity) {
        for (int i = 1; i <= goodsQuantity; i++) {
            mainPage.open();
            System.out.println(mainPage.firstRandomGoods.getCssValue("href"));
            mainPage.firstRandomGoods.click();
            if (isElementPresent(goodsPage.goodsSize)) {
                goodsPage.selectFirstSize();
            }
            goodsPage.addGoods.click();
            goodsPage.waitForQuantityChange(i);
        }
    }

    public void goToCheckout() {
            mainPage.checkoutButton.click();
        }

    public void deleteAllGoodsFromBag() {
        int goodsQuantity = bagPage.itemTypesQuantity.size() - 1;
        for (int i = goodsQuantity; i > 0; i--) {
            WebElement quantity = bagPage.goodsQuantity;
            quantity.clear();
            quantity.sendKeys("1");
            bagPage.removeGoods.click();
            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            bagPage.tableColumnDisappear(table);
        }
    }

    public String getEmptyBagMessage() {
        return bagPage.emptyBagMessage.getText();
    }

}