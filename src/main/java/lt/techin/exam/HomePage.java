package lt.techin.exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //register link element
    @FindBy(xpath = "//h4[@class='text-center']/a")
    private WebElement registerLink;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    //link click method
    public void clickRegisterLink(){registerLink.click();}

    //link assert method
    public boolean isRegisterLinkDisplayed(){return registerLink.isDisplayed();}


}
