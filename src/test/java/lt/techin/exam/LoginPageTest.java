package lt.techin.exam;

import org.junit.jupiter.api.*;


public class LoginPageTest extends TestMethods{

    //valid user account logout
    @Test
    @DisplayName("Valid User Account Logging Out")
    @Tag("Valid_Account_Logging_Out")
    void userAccountLogOutTests(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        userAccountLogOutTest();
    }

    //valid user account login
    @Test
    @DisplayName("Valid User Account Logging In")
    @Tag("Valid_Account_Logging_In")
    void userAccountLogInTests(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        userAccountLogInTest(registerPage);
    }

    //invalid user account login (invalid username)
    @Test
    @DisplayName("Invalid User Account Logging In - Invalid Username")
    @Tag("Invalid_Account_Logging_In")
    void userAccountLogInInvalidUserNameTests(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        userAccountInvalidUserNameLogInTest(registerPage);
    }

    //invalid user account login (invalid password)
    @Test
    @DisplayName("Invalid User Account Logging In - Invalid Password")
    @Tag("Invalid_Account_Logging_In")
    void userAccountLogInInvalidPasswordTests(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        userAccountInvalidPasswordLogInTest(registerPage);
    }

    //invalid user account login (invalid username)
    @Test
    @DisplayName("Invalid User Account Logging In - No Username")
    @Tag("Invalid_Account_Logging_In")
    @Tag("No_Singular_Login_Input")
    void userAccountLogInNoUserNameTests(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        userAccountNoUserNameLogInTest(registerPage);
    }

    //invalid user account login (invalid password)
    @Test
    @DisplayName("Invalid User Account Logging In - No Password")
    @Tag("Invalid_Account_Logging_In")
    @Tag("No_Singular_Login_Input")
    void userAccountLogInNoPasswordTests(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
        userAccountNoPasswordLogInTest(registerPage);
    }
}
