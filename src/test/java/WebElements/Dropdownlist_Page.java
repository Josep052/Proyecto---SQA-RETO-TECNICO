package WebElements;

import POM.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdownlist_Page extends Base {

    By usernameLogin = By.name("userName");
    By passwordLogin = By.name("password");
    By loginBtn = By.name("submit");
    By urlFlights = By.linkText("Flights");
    By closeAnuncio = By.id("dismiss-button.btn.skip");

    //dropdownlist clasico - https://opencart.abstracta.us/
    By dropdownList_Passengers = By.name("passCount");
    By dropdownList_DepartingFrom = By.name("fromPort");



    //dropdownlist bootstap y react https://react-bootstrap.github.io/components/dropdowns/
    public Dropdownlist_Page(WebDriver driver) {
        super(driver);
    }

    public void signIn (){
        if (isDisplayed(usernameLogin)) {
            type("qualityadmin", usernameLogin);
            type("pass1", passwordLogin);
            click(loginBtn);
            click(urlFlights);
            click(closeAnuncio);
        } else {
            System.out.println("Username textbox was not present");
        }
    }

    public String selectDropdownlist_Passengers(){
        WebElement dropdownList = findElement(dropdownList_Passengers);
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++){
            if(getText(options.get(i)).equals("4 ")){
                click(options.get(i));
            }
        }

        String selectedOption = "";

        for(int i = 0; i < options.size(); i++) {
            if(options.get(i).isSelected())
                selectedOption = getText(options.get(i));
        }



        return selectedOption;
    }

    public String selectDropdownList_DepartingFrom(){
        Select selectlist = new Select(findElement(dropdownList_DepartingFrom));
        selectlist.selectByVisibleText("Paris");
        return getText(selectlist.getFirstSelectedOption());
    }

    public String selectDropdownList_Passengers(){
        Select selectlist = new Select(findElement(dropdownList_DepartingFrom));
        selectlist.selectByVisibleText("1 ");
        return getText(selectlist.getFirstSelectedOption());
    }
}
