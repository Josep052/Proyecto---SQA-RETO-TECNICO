package POM;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Producto01Test extends TestCase {

    private WebDriver driver;
    Producto01 producto01;  //

    @Before
    public void setUp() throws Exception {
        producto01 = new Producto01(driver);
        driver = producto01.chromeDriverConnection();
        producto01.visit("https://sanangel.com.co/");
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

    @Test
    public void testAgregarPrimerProducto() throws InterruptedException {
        producto01.addFirstProductToCart();
        Thread.sleep(2000);
    }

    @Test
    public void testAgregarSegundoProducto() throws InterruptedException {
        producto01.addSecondProductToCart();
        Thread.sleep(2000);
    }
}
