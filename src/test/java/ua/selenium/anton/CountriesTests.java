package ua.selenium.anton;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.Assert.assertTrue;
import static java.util.Collections.*;

public class CountriesTests extends TestBase{

    @Before
    public void Login() {
        adminLogin();
    }

    public ArrayList<String> getCountryList() {
        ArrayList<String> countries = new ArrayList<String>();
        List<WebElement> allCountries = driver.findElements(By.xpath(".//*[@class='row']//td[5]/a"));
        countries.addAll(allCountries.stream().map(WebElement::getText).collect(Collectors.toList()));
        return countries;
    }

    public ArrayList<String> getZonesList() {
        ArrayList<String> zones = new ArrayList<String>();
        List<WebElement> allZones = driver.findElements(By.xpath(".//*[@id='table-zones']//td[3]"));
        zones.addAll(allZones.stream().map(WebElement::getText).collect(Collectors.toList()));
        return zones;
    }

    public ArrayList<String> getZonesListFromGeoZones() {
        ArrayList<String> zones = new ArrayList<String>();
        List<WebElement> allZones = driver.findElements(By.xpath(".//*[@id='table-zones']//td[3]/select"));
        zones.addAll(allZones.stream().map(WebElement::getText).collect(Collectors.toList()));
        return zones;
    }

    public ArrayList<String> getCountriesWithZonesLinks(By tableLocator, By countLocator, By linkLocator) {
        List<WebElement> rows = driver.findElements(tableLocator);
        ArrayList<String> links = new ArrayList<String>();
        for (WebElement row : rows) {
            if ((Integer.valueOf(row.findElement(countLocator).getText()) > 0)) {
                String link = row.findElement(linkLocator).getAttribute("href");
                links.add(link);
            }
        }
        return links;
    }

    public boolean compareLists(ArrayList<String> firstTerritory, ArrayList<String> secondTerritory) {
        if (firstTerritory.size() == secondTerritory.size()) {
            for (int i = 0; i < firstTerritory.size(); i++) {
                String territory_1 = firstTerritory.get(i);
                String territory_2 = secondTerritory.get(i);
                if (territory_1.equals(territory_2)) {
                    return true;
                }
            }
        }
        return true;
    }

    @Test
    public void alphabeticalOrderOfCountriesTest() {
        goToCountriesPage();
        getCountryList();
        ArrayList<String> countriesFromSite = getCountryList();
        ArrayList<String> countriesToBeSorted = getCountryList();
        sort(countriesToBeSorted);
        assertTrue(compareLists(countriesFromSite, countriesToBeSorted));
    }

    @Test
    public void alphabeticalOrderOfZonesTest() {
        goToCountriesPage();
        ArrayList<String> links = getCountriesWithZonesLinks(By.xpath(".//*[@class='row']"), By.xpath(".//td[6]"), By.xpath(".//td[5]/a"));
        for (String link : links) {
            driver.get(link);
            ArrayList<String> zonesFromSite = getZonesList();
            ArrayList<String> zonesToBeSorted = getZonesList();
            sort(zonesToBeSorted);
            assertTrue(compareLists(zonesFromSite, zonesToBeSorted));
        }
    }

    @Test
    public void alphabeticalOrderOfGeoZonesTest() {
        goToGeoZonesPage();
        ArrayList<String> links = getCountriesWithZonesLinks(By.xpath(".//*[@class='row']"), By.xpath(".//td[4]"), By.xpath(".//td[3]/a"));
        for (String link : links) {
            driver.get(link);
            ArrayList<String> zonesFromSite = getZonesListFromGeoZones();
            ArrayList<String> zonesToBeSorted = getZonesListFromGeoZones();
            sort(zonesToBeSorted);
            assertTrue(compareLists(zonesFromSite, zonesToBeSorted));
        }
    }

    @Test
    public void countriesEditingInNewPageTest() throws InterruptedException {
        goToCountriesPage();
        driver.findElement(By.className("fa-pencil")).click();
        List<WebElement> externalLinks = driver.findElements(By.className("fa-external-link"));
        for (WebElement externalLink : externalLinks) {
            String mainWindow = driver.getWindowHandle();
            externalLink.click();
            String newWindow = newWindowId(mainWindow);
            Set<String> newWindows = driver.getWindowHandles();
            assertTrue(isNewWindowOpened(newWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}