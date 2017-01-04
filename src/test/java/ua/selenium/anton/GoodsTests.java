package ua.selenium.anton;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

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
}
