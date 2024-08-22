package lt.techin.exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage{

    //input field elements

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInputField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement confirmPasswordInputField;

    //create account button
    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    private WebElement createAccountButton;

    //error message web elements
    @FindBy(xpath = "//span[@id='username.errors']")
    private WebElement invalidUserNameMessage;
    @FindBy(xpath = "//span[@id='password.errors']")
    private WebElement invalidPasswordMessage;
    @FindBy(xpath = "//span[@id='passwordConfirm.errors']")
    private WebElement mismatchingPasswordMessage;

    //input data
    private String userName;
    private String password;

    //invalid input data
    private String noUserName;
    private String noPassword;
    private String noConfirmPassword;
    private String tooShortUserName;
    private String tooShortPassword;
    private String tooShortConfirmPassword;
    private String tooLongUserName;
    private String tooLongPassword;
    private String tooLongConfirmPassword;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void inputNewUserDetails(){
        userName = TestDataGenerator.generateRandomUserName(8);
        password = TestDataGenerator.generateRandomPassword();

        logger.info("Generated Data:" + "\n");
        logger.info("User name: " + userName);
        logger.info("Password: " + password);
    }

    //valid data input methods
    public void inputNewUserFirstName(){userNameInputField.sendKeys(userName);}
    public void inputPassword(){passwordInputField.sendKeys(password);}
    public void inputConfirmPassword(){confirmPasswordInputField.sendKeys(password);}


    //invalid data input methods (no singular input)

    //no user name
    public void inputNewUserNoUserNameDetails(){
        noUserName = "";
        password = TestDataGenerator.generateRandomPassword();

        logger.info("Generated Data:" + "\n");
        logger.info("No user name: " + noUserName);
        logger.info("Password: " + password);
    }
    //no password
    public void inputNewUserNoPasswordDetails(){
        userName = TestDataGenerator.generateRandomUserName(8);
        noPassword = "";

        logger.info("Generated Data:" + "\n");
        logger.info("User name: " + userName);
        logger.info("No password: " + noPassword);
    }

    //mismatching password
    public void inputNewUserMismatchingPasswordsDetails(){
        userName = TestDataGenerator.generateRandomUserName(12);
        password = TestDataGenerator.generateRandomPassword();
        noConfirmPassword = "";

        logger.info("Generated Data:" + "\n");
        logger.info("User name: " + userName);
        logger.info("Password: " + password);
        logger.info("No confirm password: " + noConfirmPassword);
    }

    public void inputNoUserFirstName(){userNameInputField.sendKeys(noUserName);}
    public void inputNoUserPassword(){passwordInputField.sendKeys(noPassword);}
    public void inputNoConfirmPassword(){confirmPasswordInputField.sendKeys(noConfirmPassword);}

    //too short singular input

    public void inputNewUserTooShortUserNameDetails(){
        tooShortUserName = TestDataGenerator.generateRandomUserName(2);;
        password = TestDataGenerator.generateRandomPassword();

        logger.info("Generated Data:" + "\n");
        logger.info("Too short user name: " + tooShortUserName);
        logger.info("Password: " + password);
    }

    public void inputNewUserTooShortPasswordDetails(){
        userName = TestDataGenerator.generateRandomUserName(8);;
        tooShortPassword = "Kg";
        tooShortConfirmPassword = tooShortPassword;

        logger.info("Generated Data:" + "\n");
        logger.info("User name: " + userName);
        logger.info("Too short password: " + tooShortPassword);
        logger.info(("Too short confirm password: " + tooShortConfirmPassword));
    }

    public void inputTooShortUserFirstName(){userNameInputField.sendKeys(tooShortUserName);}
    public void inputTooShortUserPassword(){passwordInputField.sendKeys(tooShortPassword);}
    public void inputTooShortConfirmUserPassword(){confirmPasswordInputField.sendKeys(tooShortConfirmPassword);}

    //too long singular input

    public void inputNewUserTooLongUserNameDetails(){
        tooLongUserName = TestDataGenerator.generateRandomUserName(33);;
        password = TestDataGenerator.generateRandomPassword();

        logger.info("Generated Data:" + "\n");
        logger.info("Too long user name: " + tooLongUserName);
        logger.info("Password: " + password);
    }

    public void inputNewUserTooLongPasswordDetails(){
        userName = TestDataGenerator.generateRandomUserName(8);;
        tooLongPassword = "MH7DcHcxKzBFQ4Z3fjnhnR3Ydc1UZy53TEppww8VmQJY6fbeC3bamebC17F3dUgkZwQ2h9BsUWMmTMnvC9zzvYjShb25c9kJqaFF"; //100 chars
        tooLongConfirmPassword = "MH7DcHcxKzBFQ4Z3fjnhnR3Ydc1UZy53TEppww8VmQJY6fbeC3bamebC17F3dUgkZwQ2h9BsUWMmTMnvC9zzvYjShb25c9kJqaFF"; //100 chars

        logger.info("Generated Data:" + "\n");
        logger.info("User name: " + userName);
        logger.info("Too long password: " + tooLongPassword);
        logger.info(("Too long confirm password: " + tooLongConfirmPassword));
    }
    public void inputTooLongUserFirstName(){userNameInputField.sendKeys(tooLongUserName);}
    public void inputTooLongUserPassword(){passwordInputField.sendKeys(tooLongPassword);}
    public void inputTooLongConfirmUserPassword(){confirmPasswordInputField.sendKeys(tooLongConfirmPassword);}


    public void clickCreateButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(850));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    //web element assert methods
    public boolean isUserNameInputFieldDisplayed(){return userNameInputField.isDisplayed();}
    public boolean isPasswordInputFieldDisplayed(){return passwordInputField.isDisplayed();}
    public boolean isConfirmPasswordInputFieldDisplayed(){return confirmPasswordInputField.isDisplayed();}
    public boolean isCreateAccountButtonDisplayed(){return createAccountButton.isDisplayed();}

    //credential getters
    public String getUserName(){return userName;}
    public String getPassword(){return password;}

    //error message getters
    public String getInvalidUserNameMessage(){return invalidUserNameMessage.getText();}
    public String getInvalidPasswordMessage(){return invalidPasswordMessage.getText();}
    public String getMismatchingPasswordMessage(){return mismatchingPasswordMessage.getText();}

}
