package lt.techin.exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //input fields
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameInputField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputField;

    //login button
    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    private WebElement logInButton;

    //invalid data error message
    @FindBy(css = "div > span:nth-of-type(2)")
    private WebElement invalidDataErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //invalid login input data elements
    private String invalidUsername = "Krot";
    private String invalidPassword = "KtYdR";
    private String noUsername = "m";
    private String noPassword = "";

    //valid input data methods

    public void inputUserName(String userName){userNameInputField.sendKeys(userName);}
    public void inputPassword(String password){passwordInputField.sendKeys(password);}

    //invalid input data methods
    public void inputInvalidUserName(){userNameInputField.sendKeys(invalidUsername);}
    public void inputInvalidPassword(){passwordInputField.sendKeys(invalidPassword);}

    //invalid input data methods (no singular input)
    public void inputNoUserName(){userNameInputField.sendKeys(noUsername);}
    public void inputNoPassword(){passwordInputField.sendKeys(noPassword);}

    //login button click method
    public void clickLogInButton(){logInButton.click();}


    //login web element assert methods
    public boolean isUserNameInputFieldDisplayed(){return userNameInputField.isDisplayed();}
    public boolean isPasswordInputFieldDisplayed(){return passwordInputField.isDisplayed();}
    public boolean isLoginButtonDisplayed(){return logInButton.isDisplayed();}

    //invalid data error getter
    public String getInvalidDataErrorMessage(){return invalidDataErrorMessage.getText();}

}
