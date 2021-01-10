package com.bartosz;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//niektóre selektory są wydłużone dla praktyki, mogły być bardziej precyzyjne.

public class AutomationpractiseSecondTest {

    private WebDriver driver;
    public Faker faker = new Faker();
    public Random random = new Random();


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void aboutUsTest() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("[title=\"About us\"]")).click();;
    }

    @Test
    public void createAnAccount() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.className("login")).click();
        WebElement emailField = driver.findElement(By.id("email_create"));
        emailField.sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.cssSelector("[type=\"radio\"]#id_gender1")).click();
        WebElement firstname = driver.findElement
                (By.cssSelector("#customer_firstname[name=\"customer_firstname\"]"));
        firstname.sendKeys(faker.name().firstName());
        WebElement lastname = driver.findElement
                (By.cssSelector("#customer_lastname[name=\"customer_lastname\"]"));
        lastname.sendKeys(faker.name().lastName());
        WebElement emailField2 = driver.findElement(By.cssSelector(".std [data-validate=\"isEmail\"]"));
        emailField2.click();
        WebElement password = driver.findElement(By.cssSelector(".password [name=\"passwd\"]"));
        password.sendKeys("haslo1298JJ");
        WebElement birthday = driver.findElement(By.cssSelector(".selector [value=\"3\"]\n"));
        birthday.click();
        WebElement birthMonth = driver.findElement(By.cssSelector("#months [value=\"3\"]"));
        birthMonth.click();
        WebElement birthYear = driver.findElement(By.cssSelector("#uniform-years [value=\"1991\"]"));
        birthYear.click();
        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();
        driver.findElement(By.cssSelector(".form-group #firstname")).click();
        driver.findElement(By.cssSelector(".form-control#lastname")).click();
        WebElement address = driver.findElement(By.cssSelector(".form-control[name=\"address1\"]"));
        address.sendKeys(faker.address().streetAddress());
        WebElement address2 = driver.findElement(By.cssSelector(".form-control[name=\"address2\"]"));
        address2.sendKeys(faker.address().zipCode());
        WebElement city = driver.findElement(By.cssSelector(".form-control#city"));
        city.sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.cssSelector("#id_state [value=\"3\"]"));
        state.click();
        WebElement postcode = driver.findElement(By.cssSelector(".form-control#postcode"));
        postcode.sendKeys("10102");
        WebElement country = driver.findElement(By.cssSelector("#id_country [value=\"21\"]"));
        country.click();
        WebElement otherInfo = driver.findElement(By.cssSelector(".form-control#other"));
        otherInfo.sendKeys("my first \"create account\" test.");
        WebElement phoneNumber = driver.findElement(By.cssSelector(".form-control#phone_mobile"));
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        WebElement alias = driver.findElement(By.cssSelector(".form-control#alias"));
        alias.sendKeys(faker.address().cityName());
        WebElement submit = driver.findElement(By.cssSelector("#submitAccount"));
        submit.click();
        WebElement signOut = driver.findElement(By.cssSelector(".logout[rel=\"nofollow\"]"));
        signOut.click();
        WebElement mainPage = driver.findElement(By.cssSelector(".logo"));
        mainPage.click();
    }

//    @AfterMethod
//    public void shutDown(){
//        driver.quit();
//    }

}
