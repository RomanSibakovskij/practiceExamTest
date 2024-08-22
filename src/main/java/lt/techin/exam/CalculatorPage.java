package lt.techin.exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage{

    //logout link
    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/a")
    private WebElement logOutLink;


    //logout success element
    @FindBy(xpath = "//div[@class='form-group ']/span[1]")
    private WebElement logOutSuccessMessage;

    //success login confirmation element
    @FindBy(xpath = "//body/h2")
    private WebElement loginSuccess;

    //input fields
    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement firstNumberInputField;
    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement secondNumberInputField;

    //operator selector
    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement operatorSelector;

    //operator options elements
    @FindBy(xpath = "//option[@value='+']")
    private WebElement plusOption;
    @FindBy(xpath = "//option[@value='-']")
    private WebElement minusOption;
    @FindBy(xpath = "//option[@value='*']")
    private WebElement timesOption;
    @FindBy(xpath = "//option[@value='/']")
    private WebElement divideOption;


    //count button
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement countButton;

    private WebElement inputField;
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    //logout link click method
    public void clickLogOutLink(){logOutLink.click();}

    //data input methods
    





    //web element assert methods
    public boolean isLogOutLinkDisplayed(){return logOutLink.isDisplayed();}

    //logout success message getter
    public String getLogOutSuccessMessage(){return logOutSuccessMessage.getText();}

    //login confirmation text getter
    public String getLogInSuccessConfirmation(){return loginSuccess.getText();}
}
