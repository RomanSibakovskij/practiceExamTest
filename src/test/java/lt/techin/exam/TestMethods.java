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

    //calculator page test methods
    //addition operation
    protected void validCalculatorInputPlusOptionTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //web element assert
        isCalculatorPageWebElementDisplayed(calculatorPage);
        //input data
        calculatorPage.inputData();
        //singular inputs
        calculatorPage.inputNumberOne();
        calculatorPage.inputNumberTwo();
        //local comparator
        int number1 = calculatorPage.getNumber1();
        int number2 = calculatorPage.getNumber2();
        int expectedResult = number1 + number2;
        //operator selection
        calculatorPage.selectPlusOption();
        //assert the plus was selected
        verifyOperatorSelected(calculatorPage, "Sudėtis", calculatorPage.isPlusOperatorDisplayed());
        //count button click
        calculatorPage.clickCountButton();
        //display the calculation result
        calculatorPage.getCalculationResult();
        logger.info("Calculation result: " + calculatorPage.getCalculationResult());
        //local comparison of the result with the result displayed (in case the calculator doesn't display correct results)
        int actualResult = Integer.parseInt(calculatorPage.getCalculationResult());
        assertEquals(expectedResult, actualResult, "The local addition result is incorrect");
        logger.info("The local answer is: " + actualResult);
    }

    //subtraction operation
    protected void validCalculatorInputMinusOptionTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //web element assert
        isCalculatorPageWebElementDisplayed(calculatorPage);
        //input data
        calculatorPage.inputData();
        //singular inputs
        calculatorPage.inputNumberOne();
        calculatorPage.inputNumberTwo();
        //local comparator
        int number1 = calculatorPage.getNumber1();
        int number2 = calculatorPage.getNumber2();
        int expectedResult = number1 - number2;
        //operator selection
        calculatorPage.selectMinusOption();
        //assert the plus was selected
        verifyOperatorSelected(calculatorPage, "Atimtis", calculatorPage.isPlusOperatorDisplayed());
        //count button click
        calculatorPage.clickCountButton();
        //display the calculation result
        calculatorPage.getCalculationResult();
        logger.info("Calculation result: " + calculatorPage.getCalculationResult());
        //local comparison of the result with the result displayed (in case the calculator doesn't display correct results)
        int actualResult = Integer.parseInt(calculatorPage.getCalculationResult());
        assertEquals(expectedResult, actualResult, "The local addition result is incorrect");
        logger.info("The local answer is: " + actualResult);
    }

    //multiplication operation
    protected void validCalculatorInputTimesOptionTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //web element assert
        isCalculatorPageWebElementDisplayed(calculatorPage);
        //input data
        calculatorPage.inputData();
        //singular inputs
        calculatorPage.inputNumberOne();
        calculatorPage.inputNumberTwo();
        //local comparator
        int number1 = calculatorPage.getNumber1();
        int number2 = calculatorPage.getNumber2();
        int expectedResult = number1 * number2;
        //operator selection
        calculatorPage.selectTimesOption();
        //assert the plus was selected
        verifyOperatorSelected(calculatorPage, "Daugyba", calculatorPage.isPlusOperatorDisplayed());
        //count button click
        calculatorPage.clickCountButton();
        //display the calculation result
        calculatorPage.getCalculationResult();
        logger.info("Calculation result: " + calculatorPage.getCalculationResult());
        //local comparison of the result with the result displayed (in case the calculator doesn't display correct results)
        int actualResult = Integer.parseInt(calculatorPage.getCalculationResult());
        assertEquals(expectedResult, actualResult, "The local addition result is incorrect");
        logger.info("The local answer is: " + actualResult);
    }

    //division operation
    protected void validCalculatorInputDivideOptionTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //web element assert
        isCalculatorPageWebElementDisplayed(calculatorPage);
        //input data
        calculatorPage.inputData();
        //singular inputs
        calculatorPage.inputNumberOne();
        calculatorPage.inputNumberTwo();
        //local comparator
        int number1 = calculatorPage.getNumber1();
        int number2 = calculatorPage.getNumber2();
        int expectedResult = number1 / number2;
        //operator selection
        calculatorPage.selectDivideOption();
        //assert the plus was selected
        verifyOperatorSelected(calculatorPage, "Dalyba", calculatorPage.isPlusOperatorDisplayed());
        //count button click
        calculatorPage.clickCountButton();
        //display the calculation result
        calculatorPage.getCalculationResult();
        logger.info("Calculation result: " + calculatorPage.getCalculationResult());
        //local comparison of the result with the result displayed (in case the calculator doesn't display correct results)
        int actualResult = Integer.parseInt(calculatorPage.getCalculationResult());
        assertEquals(expectedResult, actualResult, "The local addition result is incorrect");
        logger.info("The local answer is: " + actualResult);
    }

    //invalid calculator page test methods (strings as variables)
    //addition operation
    protected void invalidCalculatorInputPlusOptionTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //web element assert
        isCalculatorPageWebElementDisplayed(calculatorPage);
        //input data
        calculatorPage.inputData();
        //singular inputs
        calculatorPage.inputNumberOne();
        calculatorPage.inputNumberTwo();
        //operator selection
        calculatorPage.selectPlusOption();
        //assert the plus was selected
        verifyOperatorSelected(calculatorPage, "Sudėtis", calculatorPage.isPlusOperatorDisplayed());
        //count button click
        calculatorPage.clickCountButton();
//        //display the calculation result
//        calculatorPage.getCalculationResult();
//        logger.info("Calculation result: " + calculatorPage.getCalculationResult());
    }

    //calculator page web element assert methods
    protected void isCalculatorPageWebElementDisplayed(CalculatorPage calculatorPage){
        //assert the number 1 input field is displayed
        assertTrue(calculatorPage.isFirstNumberInputFieldDisplayed(), "The number 1 input field isn't displayed");
        //assert the number 2 input field is displayed
        assertTrue(calculatorPage.isSecondNumberInputFieldDisplayed(), "The number 2 input field isn't displayed");
        //assert the operator selector is displayed
        assertTrue(calculatorPage.isOperatorSelectorDisplayed(), "The operator selector isn't displayed");
        //assert the count button is displayed
        assertTrue(calculatorPage.isCountButtonDisplayed(), "The count button isn't displayed");
    }
    //selected operator assert method
    protected void verifyOperatorSelected(CalculatorPage calculatorPage, String operator, boolean isSelected) {
        assertTrue(isSelected, "The " + operator + " operator is not selected");
        logger.info("The " + operator + " operator is selected\n");
    }

}
