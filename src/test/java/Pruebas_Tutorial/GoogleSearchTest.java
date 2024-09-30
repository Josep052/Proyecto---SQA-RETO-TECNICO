package Pruebas_Tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;
    By videoLinkLocator = By.cssSelector("href=https://www.youtube.com/watch?v=R_hh3jAqn8M");
    @Before
    public void setUp() {
        // Setting up Chrome driver
        System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testGooglePage() {
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("quality-stream Introducción a la automatización de pruebas de software");
        searchbox.submit();

        // explicit wait using WebDriverWait
        // WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // ewait.until(ExpectedConditions.titleContains("quality-stream"));

        // assertEquals("quality-stream Introducción a la automatización de pruebas de software - Buscar con Google", driver.getTitle());

        // fluent wait using FluentWait
        Wait<WebDriver> fwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement video = fwait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(videoLinkLocator);
            }
        }
        );

        assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
    }

    @After
    public void tearDown() {
        // Quitting the browser
        // driver.quit();
    }
}
