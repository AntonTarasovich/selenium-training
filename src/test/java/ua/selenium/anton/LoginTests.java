package ua.selenium.anton;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginTests extends TestBase{

    @Test
    public void myFirstTest() {
        adminLogin();
        wait.until(titleIs("My Store"));
    }

    @Test
    public void allAdminSectionsPassTest() {
        adminLogin();
        driver.findElement(By.cssSelector("#app-:nth-child(1)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-template")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-logotype")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(2)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-catalog")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-product_groups")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-option_groups")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-manufacturers")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-suppliers")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-delivery_statuses")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-sold_out_statuses")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-quantity_units")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(3)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(4)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(5)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-customers")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-newsletter")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(6)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(7)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-languages")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-storage_encoding")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(8)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-jobs")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-customer")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-shipping")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-payment")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-order_total")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-order_success")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-order_action")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(9)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-orders")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-order_statuses")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(10)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(11)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-monthly_sales")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-most_sold_products")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-most_shopping_customers")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(12)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-store_info")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-defaults")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-general")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-listings")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-images")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-checkout")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-advanced")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-security")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(13)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(14)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-tax_classes")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-tax_rates")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(15)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-search")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-scan")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(16)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#app-:nth-child(17)")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
        driver.findElement(By.cssSelector("#doc-vqmods")).click();
        assertTrue(isElementPresent(By.tagName("h1")));
    }

    @Test
    public void userRegistrationTest() {
        String mail = generateMail();
        String password = "123456";
        String firstName = "Vasya";
        String lastName = "Pupkin";
        goToMainPage();
        driver.findElement(By.cssSelector("#box-account-login a")).click();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("address1")).sendKeys("Mayakovskogo str., 14");
        driver.findElement(By.name("postcode")).sendKeys("04881");
        driver.findElement(By.name("city")).sendKeys("Kiev");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("phone")).sendKeys("+380445555555");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.xpath(".//*[@id='box-account']//li[4]/a")).click();
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        assertTrue(driver.findElement(By.cssSelector("#notices>div")).getText().equals("You are now logged in as "
                + firstName + " " + lastName +"."));
    }
}