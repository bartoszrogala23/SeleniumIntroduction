package com.bartosz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void googleSearch() {
        driver.get("http://google.com");
        driver.switchTo().frame(0);
        driver.findElement(By.id("introAgreeButton")).click();
        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.cssSelector("input[name=q]"));
        searchField.sendKeys("Transformers");
        searchField.sendKeys(Keys.ENTER);
        WebElement found = driver.findElement(By.cssSelector("#search"));
        List<WebElement> searchedElements = found.findElements(By.cssSelector("div.g a h3"));
        searchedElements.forEach(webElement ->
                System.out.println(webElement.getText()));
        assertThat(searchedElements)
                .as("Lnks to googled sites")
                .allMatch(
                        webElement -> webElement.getText().contains("Transformers")
                );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
