package com.bartosz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TheInternetTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectAllCheckbox() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/checkboxes];")).click();
        WebElement found = driver.findElement(By.cssSelector("#search"));
        List<WebElement> searchedElements = found.findElements(By.cssSelector("input[type=checkbox]"));
        searchedElements.forEach(webElement -> {
                    if (! webElement.isSelected()){
                        webElement.click();
                    }
                }
        );
    }

    @Test
    public void deselectAllCheckbox() {
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/checkboxes];")).click();
        WebElement found = driver.findElement(By.cssSelector("#search"));
        List<WebElement> searchedElements = found.findElements(By.cssSelector("input[type=checkbox]"));
        searchedElements.forEach(webElement -> {
                    if(webElement.isSelected()){
                        webElement.click();
                    }
                }
        );

        List<WebElement> checkboxes = found.findElements(By.cssSelector("input[type=checkbox]"));

    }

}
