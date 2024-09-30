package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Producto01 extends Base {

    By NameProduct = By.xpath("//*[@id='destacados-tab']/div[2]/div/ul/li[2]/a[2]/img");
    By QuantityInput = By.className("input-text");
    By addToCartButton = By.className("single_add_to_cart_button");

    public Producto01(WebDriver driver) {
        super(driver);
    }

    public void signIn() {
        click(NameProduct); // Hacer clic en el producto

        // Acceder al campo de cantidad y establecer el valor
        WebElement quantityField = driver.findElement(QuantityInput);
        quantityField.clear();
        quantityField.sendKeys("2"); // Establecer la cantidad deseada

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("blockOverlay")));

        // Hacer clic en "Añadir al carrito"
        click(addToCartButton);
    }
}
