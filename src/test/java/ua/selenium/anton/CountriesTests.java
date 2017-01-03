package ua.selenium.anton;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
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

    public ArrayList<String> getCountriesWithZonesLinks() {
        List<WebElement> rows = driver.findElements(By.xpath(".//*[@class='row']"));
        ArrayList<String> links = new ArrayList<String>();
        for (WebElement row : rows) {
            if ((Integer.valueOf(row.findElement(By.xpath(".//td[6]")).getText()) > 0)) {
                String link = row.findElement(By.xpath(".//td[5]/a")).getAttribute("href");
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
        ArrayList<String> links = getCountriesWithZonesLinks();
        for (String link : links) {
            driver.get(link);
            ArrayList<String> zonesFromSite = getZonesList();
            ArrayList<String> zonesToBeSorted = getZonesList();
            sort(zonesToBeSorted);
            assertTrue(compareLists(zonesFromSite, zonesToBeSorted));
        }
    }
}