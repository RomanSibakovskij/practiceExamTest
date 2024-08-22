package lt.techin.exam;

import org.slf4j.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethods extends BaseTest{

    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    //register link navigation test method
    protected void navigateToRegisterPageTest(){
        HomePage homePage = new HomePage(driver);
        //assert the register link is displayed
        assertTrue(homePage.isRegisterLinkDisplayed(), "The link isn't displayed");
        //register link click
        homePage.clickRegisterLink();
    }

    //valid user account creation test method
    protected void validUserAccountCreation(RegisterPage registerPage){
         navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserDetails();
        //singular field input
        registerPage.inputNewUserFirstName();
        registerPage.inputPassword();
        registerPage.inputConfirmPassword();
        registerPage.clickCreateButton();
    }

    //invalid user account creation test methods
    //no username
    protected void noUserNameAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserNoUserNameDetails();
        //singular field input
        registerPage.inputNoUserFirstName();
        registerPage.inputPassword();
        registerPage.inputConfirmPassword();
        registerPage.clickCreateButton();
    }
    //no password
    protected void noPasswordAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserNoPasswordDetails();
        //singular field input
        registerPage.inputNewUserFirstName();
        registerPage.inputNoUserPassword();
        registerPage.clickCreateButton();
    }

    //no password
    protected void noConfirmPasswordAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserMismatchingPasswordsDetails();
        //singular field input
        registerPage.inputNewUserFirstName();
        registerPage.inputPassword();
        registerPage.inputNoConfirmPassword();
        registerPage.clickCreateButton();
    }

    //too short singular input

    protected void tooShortUserNameAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserTooShortUserNameDetails();
        //singular field input
        registerPage.inputTooShortUserFirstName();
        registerPage.inputPassword();
        registerPage.inputConfirmPassword();
        registerPage.clickCreateButton();
    }

    protected void tooShortPasswordAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserTooShortPasswordDetails();
        //singular field input
        registerPage.inputNewUserFirstName();
        registerPage.inputTooShortUserPassword();
        registerPage.inputTooShortConfirmUserPassword();
        registerPage.clickCreateButton();
    }

    //too short singular input

    protected void tooLongUserNameAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserTooLongUserNameDetails();
        //singular field input
        registerPage.inputTooLongUserFirstName();
        registerPage.inputPassword();
        registerPage.inputConfirmPassword();
        registerPage.clickCreateButton();
    }

    protected void tooLongPasswordAccountCreationTest(RegisterPage registerPage){
        navigateToRegisterPageTest();
        //register page web element assert
        isHomePageWebElementDisplayed(registerPage);
        //data input
        registerPage.inputNewUserTooLongPasswordDetails();
        //singular field input
        registerPage.inputNewUserFirstName();
        registerPage.inputTooLongUserPassword();
        registerPage.inputTooLongConfirmUserPassword();
        registerPage.clickCreateButton();
    }

    //register page web element asserts
    protected void isHomePageWebElementDisplayed(RegisterPage registerPage){
        //assert username input field is displayed
        assertTrue(registerPage.isUserNameInputFieldDisplayed(), "The username input field isn't displayed");
        assertTrue(registerPage.isPasswordInputFieldDisplayed(), "The password input field isn't displayed");
        assertTrue(registerPage.isConfirmPasswordInputFieldDisplayed(), "The confirm password input field isn't displayed");
        assertTrue(registerPage.isCreateAccountButtonDisplayed(), "The create account button isn't displayed");
    }

    //user account logout test method
    protected void userAccountLogOutTest(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //assert the logout link is displayed
        assertTrue(calculatorPage.isLogOutLinkDisplayed(), "The logout link isn't displayed");
        calculatorPage.clickLogOutLink();
        //assert the expected message is displayed
        assertEquals(calculatorPage.getLogOutSuccessMessage(), "Sėkmingai atsijungėte", "The expected message didn't appear");
    }

    //user account login test method
    protected void userAccountLogInTest(RegisterPage registerPage){
        userAccountLogOutTest();
        LoginPage loginPage = new LoginPage(driver);
        isLoginPageWebElementDisplayed(loginPage);
        loginPage.inputUserName(registerPage.getUserName());
        logger.info("Username used for login: " + registerPage.getUserName());
        loginPage.inputPassword(registerPage.getPassword());
        logger.info("Password used for login: " + registerPage.getPassword());
        loginPage.clickLogInButton();
        //confirm the login was successful
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        assertEquals(calculatorPage.getLogInSuccessConfirmation(), "Galimos operacijos: sudėti, atimti, dauginti, dalinti", "The message isn't displayed");
    }

    //invalid user account login test method (invalid username)
    protected void userAccountInvalidUserNameLogInTest(RegisterPage registerPage){
        userAccountLogOutTest();
        LoginPage loginPage = new LoginPage(driver);
        isLoginPageWebElementDisplayed(loginPage);
        loginPage.inputInvalidUserName();
        loginPage.inputPassword(registerPage.getPassword());
        logger.info("Username used for login: " + registerPage.getUserName());
        loginPage.clickLogInButton();
        //confirm the login was not successful
        assertEquals(loginPage.getInvalidDataErrorMessage(), "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", "The message isn't displayed");
    }

    //user account login test method (invalid password)
    protected void userAccountInvalidPasswordLogInTest(RegisterPage registerPage){
        userAccountLogOutTest();
        LoginPage loginPage = new LoginPage(driver);
        isLoginPageWebElementDisplayed(loginPage);
        loginPage.inputUserName(registerPage.getUserName());
        logger.info("Password used for login: " + registerPage.getPassword());
        loginPage.inputInvalidPassword();
        loginPage.clickLogInButton();
        //confirm the login was not successful
        assertEquals(loginPage.getInvalidDataErrorMessage(), "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", "The message isn't displayed");
    }

    //invalid user account login test method (no username)
    protected void userAccountNoUserNameLogInTest(RegisterPage registerPage){
        userAccountLogOutTest();
        LoginPage loginPage = new LoginPage(driver);
        isLoginPageWebElementDisplayed(loginPage);
        loginPage.inputNoUserName();
        loginPage.inputPassword(registerPage.getPassword());
        logger.info("Password used for login: " + registerPage.getPassword());
        loginPage.clickLogInButton();
        //confirm the login was not successful
        assertEquals(loginPage.getInvalidDataErrorMessage(), "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", "The message isn't displayed");
    }

    //user account login test method (no password)
    protected void userAccountNoPasswordLogInTest(RegisterPage registerPage){
        userAccountLogOutTest();
        LoginPage loginPage = new LoginPage(driver);
        isLoginPageWebElementDisplayed(loginPage);
        loginPage.inputUserName(registerPage.getUserName());
        logger.info("Username used for login: " + registerPage.getUserName());
        loginPage.inputNoPassword();
        loginPage.clickLogInButton();
        //confirm the login was not successful
        assertEquals(loginPage.getInvalidDataErrorMessage(), "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", "The message isn't displayed");
    }

    //login page assert method
    protected void isLoginPageWebElementDisplayed(LoginPage loginPage){
        //assert the username input field is displayed
        assertTrue(loginPage.isUserNameInputFieldDisplayed(), "The username input field isn't displayed");
        //assert the username input field is displayed
        assertTrue(loginPage.isPasswordInputFieldDisplayed(), "The password input field isn't displayed");
        //assert the username input field is displayed
        assertTrue(loginPage.isLoginButtonDisplayed(), "The login button isn't displayed");
    }

}
