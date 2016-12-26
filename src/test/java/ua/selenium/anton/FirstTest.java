package ua.selenium.anton;

import org.junit.*;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends TestBase{

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}