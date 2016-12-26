package ua.selenium.anton;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
}
