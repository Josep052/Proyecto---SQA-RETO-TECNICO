package Pruebas_Tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MercuryTour_AutomatedTest {

    private WebDriver driver;
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[contains(@src, 'mast_register.gif')]");
    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerBtnLocator = By.name("submit");

    By usernameLogin = By.name("userName");
    By passwordLogin = By.name("password");
    By loginBtn = By.name("submit");
    By homePageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void registerUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(registerPageLocator).isDisplayed()) {
            driver.findElement(usernameLocator).sendKeys("qualityadmin");
            driver.findElement(passwordLocator).sendKeys("pass1");
            driver.findElement(confirmPasswordLocator).sendKeys("pass1");
            driver.findElement(registerBtnLocator).click();

        } else {
            System.out.println("Register page was not found");
        }

        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is qualityadmin.", fonts.get(5).getText());
    }

    @Test
    public void LoginUser() throws InterruptedException {
        driver.findElement(usernameLogin).sendKeys("qualityadmin");
        driver.findElement(passwordLogin).sendKeys("pass1");
        driver.findElement(loginBtn).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(homePageLocator).isDisplayed());
        // Assertion para verificar el mensaje de éxito al iniciar sesión


    }
}
