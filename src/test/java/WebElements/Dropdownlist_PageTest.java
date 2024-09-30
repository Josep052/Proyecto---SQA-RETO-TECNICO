package WebElements;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class Dropdownlist_PageTest extends TestCase {

    private WebDriver driver;
    Dropdownlist_Page ddlPage;

    @Before
    public void setUp() throws Exception {
        ddlPage = new Dropdownlist_Page(driver);
        driver = ddlPage.chromeDriverConnection();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testing_classic_DDL() {
        ddlPage.visit("https://demo.guru99.com/test/newtours/index.php");
        ddlPage.signIn();
        assertEquals(ddlPage.selectDropdownlist_Passengers(),"4 ");
        assertEquals(ddlPage.selectDropdownList_DepartingFrom(),"Paris");
    }
}