package com.bartosz;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AutomationPractiseAddToCart {
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
    public void addToCart() {
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
        WebElement womenSection = driver.findElement(By.cssSelector
                (".last [href=\"http://automationpractice.com/index.php?id_category=3&controller=category\"]"));
        womenSection.click();
        WebElement category = driver.findElement(By.cssSelector
                (".last [href=\"http://automationpractice.com/index.php?id_category=3&controller=category\"]"));
        category.click();
        WebElement dresses = driver.findElement(By.cssSelector(".subcategory-image [title=\"Dresses\"]"));
        dresses.click();
        WebElement eveningDresses = driver.findElement
                (By.cssSelector("[src=\"http://automationpractice.com/img/c/10-medium_default.jpg\"]"));
        eveningDresses.click();
        WebElement certainDress = dresses.findElement(By.cssSelector(".replace-2x[title=\"Printed Dress\"]"));
// od tego momentu nie dziala prawidlowo
        WebElement add = driver.findElement(By.cssSelector(".ajax_add_to_cart_button"));
//        add.click();
        WebElement checkout1 = driver.findElement(By.cssSelector("[title=\"Proceed to checkout\"]"));
        checkout1.click();
        WebElement addByPlus = driver.findElement(By.cssSelector(".icon-plus"));
        addByPlus.click();
        WebElement checkout2 = driver.findElement(By.cssSelector(".standard-checkout[title=\"Proceed to checkout\"]"));
        checkout2.click();
//        WebElement processAddress = driver.findElement(By.cssSelector("[name=\"cgv\"]"));
//        processAddress.click();
//        WebElement cgv = driver.findElement(By.cssSelector("#submitAccount"));
////        cgv.click();
//        WebElement processCarrier = driver.findElement(By.cssSelector("[name=\"processCarrier\"]"));
//        processCarrier.click();
//        WebElement cheque = driver.findElement(By.cssSelector(".cheque"));
//        cheque.click();
//        WebElement submit2 = driver.findElement(By.cssSelector("[type=\"submit\"].button-medium"));
//        submit2.click();

    }
}
