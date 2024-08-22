package lt.techin.exam;

import org.junit.jupiter.api.*;


public class HomePageTest extends TestMethods{

    @Test
    @DisplayName("Navigation To Register Page")
    @Tag("Navigate_To_Homepage")
    void gotoRegisterPageTest(){
        navigateToRegisterPageTest();
    }
}
