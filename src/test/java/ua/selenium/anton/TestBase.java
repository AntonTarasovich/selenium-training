package ua.selenium.anton;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class TestBase {

    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
            File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screen = new File("screen" + System.currentTimeMillis() + ".png");
            try {
                Files.copy(tempFile, screen);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(screen);
        }
    }

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        wait = new WebDriverWait(driver, 10);
        return;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public void adminLogin() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public void goToMainPage() {
        driver.navigate().to("http://localhost/litecart/");
    }

    public void goToCatalogPage() {
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=2");
    }

    public void goToCountriesPage() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    public void  goToCheckout() {
        driver.findElement(By.xpath(".//*[@id='cart']/a[@class='link']")).click();
    }

    public void goToGeoZonesPage() {
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    public String generateMail() {
        Long date = new Date().getTime();
        String mail = "vasya" + date + "@mail.ru";
        return mail;
    }

    public ArrayList<String> getGoodsNames() {
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@class='row']//td[3]/a"));
        ArrayList<String> goodsNames = elements.stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
        return goodsNames;
    }

    public String generateGoodsName() {
        Long date = new Date().getTime();
        String goodsName = "Batman" + date;
        return goodsName;
    }

    public void addGoodsToBag(int goodsQuantity) {
        for (int i = 1; i <= goodsQuantity; i++) {
            goToMainPage();
            driver.findElement(By.xpath(".//*[@id='box-most-popular']//a")).click();
            if (driver.findElements(By.name("options[Size]")).size() > 0) {
                Select goodsSize = new Select(driver.findElement(By.name("options[Size]")));
                goodsSize.selectByIndex(1);
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(textToBe(By.xpath(".//span[@class='quantity']"), Integer.toString(i)));
        }
    }

    public void deleteAllGoodsFromBag() {
        int goodsQuantity = driver.findElements(By.cssSelector(".dataTable .item")).size() - 1;
        for (int i = goodsQuantity; i > 0; i--) {
            WebElement quantity = driver.findElement(By.name("quantity"));
            quantity.clear();
            quantity.sendKeys("1");
            driver.findElement(By.name("remove_cart_item")).click();
            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            wait.until(stalenessOf(table));
        }
    }

    boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    boolean isElementNotPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return driver.findElements(locator).size() == 0;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public String newWindowId(String oldWindow) throws InterruptedException {
        String newWindow = "";
        while (driver.getWindowHandles().size() == 1) {
            Thread.sleep(500);
        }
        for (String window : driver.getWindowHandles()) {
            if (! window.equals(oldWindow)) {
                newWindow = window;
            }
        }
        return newWindow;
    }

    public boolean isNewWindowOpened(Set<String> windows) {
        return windows.size() > 1;
    }
}