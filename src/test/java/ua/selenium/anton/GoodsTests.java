package ua.selenium.anton;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoodsTests extends TestBase{

    @Test
    public void checkGoodsLabelsTest() {
        goToMainPage();
        List<WebElement> goods = driver.findElements(By.cssSelector(".link .image-wrapper"));
        for (WebElement good : goods) {
            assertTrue(good.findElements(By.cssSelector("div[class*=sticker]")).size() == 1);
        }
    }

    @Test
    public void rightDuckPageTest() {
        goToMainPage();
        String mainDuckName = driver.findElement(By.xpath(".//*[@id='box-campaigns']//a[1]")).getAttribute("title");
        String mainFullPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
        assertTrue((driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color")).equals("rgba(119, 119, 119, 1)"));
        assertTrue((driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName()).equals("s"));
        assertTrue((driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("font-size")).equals("14.4px"));
        String mainDiscountPrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();
        assertTrue((driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color")).equals("rgba(204, 0, 0, 1)"));
        assertTrue((driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-weight")).equals("bold"));
        assertTrue((driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-size")).equals("18px"));
        driver.findElement(By.xpath(".//*[@id='box-campaigns']//a[1]")).click();
        String pageDuckName = driver.findElement(By.xpath(".//*[@id='box-product']//h1")).getText();
        String pageFullPrice = driver.findElement(By.cssSelector(".regular-price")).getText();
        assertTrue((driver.findElement(By.cssSelector(".regular-price")).getCssValue("color")).equals("rgba(102, 102, 102, 1)"));
        assertTrue((driver.findElement(By.cssSelector(".regular-price")).getTagName()).equals("s"));
        assertTrue((driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size")).equals("16px"));
        String pageDiscountPrice = driver.findElement(By.cssSelector(".campaign-price")).getText();
        assertTrue((driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color")).equals("rgba(204, 0, 0, 1)"));
        assertTrue((driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight")).equals("bold"));
        assertTrue((driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size")).equals("22px"));
        assertTrue(mainDuckName.equals(pageDuckName));
        assertTrue(mainFullPrice.equals(pageFullPrice));
        assertTrue(mainDiscountPrice.equals(pageDiscountPrice));
    }

    @Test
    public void newGoodsAddTest() {
        String goodsName = generateGoodsName();
        adminLogin();
        driver.findElement(By.xpath(".//*[@id='app-'][2]")).click();
        driver.findElement(By.xpath(".//*[@id='content']//a[2]")).click();
        driver.findElement(By.xpath(".//*[@id='tab-general']//label[1]")).click();
        driver.findElement(By.name("name[en]")).sendKeys(goodsName);
        driver.findElement(By.name("code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='1-3']")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("1000");
        driver.findElement(By.name("new_images[]")).sendKeys("D:\\batman.png");
        driver.findElement(By.name("date_valid_from")).sendKeys("2017-01-09");
        driver.findElement(By.name("date_valid_to")).sendKeys("2018-01-09");
        driver.findElement(By.xpath(".//*[@class='tabs']//li[2]")).click();
        Select goodsManufacturer = new Select(driver.findElement(By.name("manufacturer_id")));
        goodsManufacturer.selectByIndex(1);
        driver.findElement(By.name("short_description[en]")).sendKeys("goodsName");
        driver.findElement(By.name("description[en]")).sendKeys("Darker than night!");
        driver.findElement(By.name("head_title[en]")).sendKeys("BATMAN!!!");
        driver.findElement(By.xpath(".//*[@class='tabs']//li[4]")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("1");
        Select price = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        price.selectByIndex(1);
        driver.findElement(By.name("prices[USD]")).sendKeys("10000");
        driver.findElement(By.name("save")).click();
        assertTrue(getGoodsNames().contains(goodsName));
    }

    @Test
    public void deleteGoodsFromBagTest() {
        addGoodsToBag(3);
        goToCheckout();
        deleteAllGoodsFromBag();
        assertTrue((driver.findElement(By.tagName("em")).getText()).equals("There are no items in your cart."));
    }
}
