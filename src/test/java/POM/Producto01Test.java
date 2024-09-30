package POM;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Producto01Test extends TestCase {


    private WebDriver driver;
    Producto01 signInPage;


    @Before
    public void setUp() throws Exception {
        signInPage = new Producto01(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit("https://sanangel.com.co/");
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();

    }

    @Test
    public void test ()throws InterruptedException {
        signInPage.signIn();
        Thread.sleep(2000);
    }
}