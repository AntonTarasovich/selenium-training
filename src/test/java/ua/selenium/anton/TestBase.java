package ua.selenium.anton;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
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

    public void goToCountriesPage() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    public void goToGeoZonesPage() {
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    public String generateMail() {
        Long date = new Date().getTime();
        String mail = "vasya" + date + "@mail.ru";
        return mail;
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
}