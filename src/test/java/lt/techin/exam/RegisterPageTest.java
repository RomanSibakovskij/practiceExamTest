package lt.techin.exam;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterPageTest extends TestMethods {

    //valid user account creation
    @Test
    @DisplayName("Valid User Account Creation")
    @Tag("Valid_Account_Creation")
    void newUserAccountCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        validUserAccountCreation(registerPage);
    }

    //invalid user account creation (no username)
    @Test
    @DisplayName("No User Name Account Creation")
    @Tag("Invalid_Account_Creation")
    @Tag("No_Singular_Input")
    void noUserNameUserAccountCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        noUserNameAccountCreationTest(registerPage);
        //assert the expected error message appears
        assertEquals(registerPage.getInvalidUserNameMessage(), "Šį laukelį būtina užpildyti\n" +
                "Privaloma įvesti nuo 3 iki 32 simbolių", "The error message didn't appear");
    }

    //invalid user account creation (no password)
    @Test
    @DisplayName("No Password Account Creation")
    @Tag("Invalid_Account_Creation")
    @Tag("No_Singular_Input")
    void noPasswordUserAccountCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        noPasswordAccountCreationTest(registerPage);
        //assert the expected error message appears
        assertEquals(registerPage.getInvalidPasswordMessage(), "Šį laukelį būtina užpildyti\n" +
                "Privaloma įvesti bent 3 simbolius", "The error message didn't appear");
    }

    //invalid user account creation (no password)
    @Test
    @DisplayName("Mismatching Password Account Creation")
    @Tag("Invalid_Account_Creation")
    @Tag("Mismatching_Singular_Input")
    void mismatchingPasswordUserAccountCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        noConfirmPasswordAccountCreationTest(registerPage);
        //assert the expected error message appears
        assertEquals(registerPage.getMismatchingPasswordMessage(), "Įvesti slaptažodžiai nesutampa", "The error message didn't appear");
    }

    //invalid user account creation (too short username)
    @Test
    @DisplayName("User Account Creation - Too Short Username")
    @Tag("Invalid_Account_Creation")
    @Tag("Too_Short_Singular_Input")
    void tooShortUserNameCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        tooShortUserNameAccountCreationTest(registerPage);
        //assert the expected error message appears
       assertEquals(registerPage.getInvalidUserNameMessage(), "Privaloma įvesti nuo 3 iki 32 simbolių", "The error message didn't appear");
    }
    //invalid user account creation (too short password)
    @Test
    @DisplayName("User Account Creation - Too Short Password")
    @Tag("Invalid_Account_Creation")
    @Tag("Too_Short_Singular_Input")
    void tooShortPasswordCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        tooShortPasswordAccountCreationTest(registerPage);
        //assert the expected error message appears
        assertEquals(registerPage.getInvalidPasswordMessage(), "Privaloma įvesti bent 3 simbolius", "The error message didn't appear");
    }

    //invalid user account creation (too long username)
    @Test
    @DisplayName("User Account Creation - Too Long Username")
    @Tag("Invalid_Account_Creation")
    @Tag("Too_Long_Singular_Input")
    void tooLongUserNameCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        tooLongUserNameAccountCreationTest(registerPage);
        //assert the expected error message appears
        assertEquals(registerPage.getInvalidUserNameMessage(), "Privaloma įvesti nuo 3 iki 32 simbolių", "The error message didn't appear");
    }
    //invalid user account creation (too long password)
    @Test
    @DisplayName("User Account Creation - Too Long Password")
    @Tag("Invalid_Account_Creation")
    @Tag("Too_Long_Singular_Input")
    void tooLongPasswordCreationTest(){

        RegisterPage registerPage = new RegisterPage(driver);
        tooLongPasswordAccountCreationTest(registerPage);
        //assert the expected error message appears
        assertEquals(registerPage.getInvalidPasswordMessage(), "Privaloma įvesti bent 3 simbolius", "The error message didn't appear"); //it doesn't have a valid too long password error message so the standard msg was used instead
    }
}
