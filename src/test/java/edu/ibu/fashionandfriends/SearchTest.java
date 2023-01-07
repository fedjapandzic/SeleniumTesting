package edu.ibu.fashionandfriends;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String baseUrl;

    @BeforeAll
    static void setUp() throws Exception{
        driver = new ChromeDriver();
        baseUrl = "https://www.fashionandfriends.com/ba/";
    }
    @AfterAll
    static void close() throws Exception{
//        driver.quit();
    }

    @Test
    public void TestSearchFunction(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement searchBar = driver.findElement(By.id("search"));
        searchBar.sendKeys("Paccioti");
        searchBar.submit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement searchResult = driver.findElement(By.cssSelector("span.base[data-ui-id='page-title-wrapper']"));
        Assert.assertEquals("REZULTATI PRETRAGE ZA: PACCIOTI",searchResult.getText());

    }
}
