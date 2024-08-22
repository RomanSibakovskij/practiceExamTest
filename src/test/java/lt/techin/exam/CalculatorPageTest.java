package lt.techin.exam;

import org.junit.jupiter.api.*;

public class CalculatorPageTest extends TestMethods{

    //valid calculator tests
    @Test
    @DisplayName("Valid Addition Test")
    @Tag("Valid_Calculation_Test")
    void validAdditionOptionTest(){
        validCalculatorInputPlusOptionTest();
    }
    @Test
    @DisplayName("Valid Subtraction Test")
    @Tag("Valid_Calculation_Test")
    void validSubtractionOptionTest(){
        validCalculatorInputMinusOptionTest();
    }
    @Test
    @DisplayName("Valid Multiplication Test")
    @Tag("Valid_Calculation_Test")
    void validMultiplicationOptionTest(){
        validCalculatorInputTimesOptionTest();
    }
    @Test
    @DisplayName("Valid Division Test")
    void validDivisionOptionTest(){
        validCalculatorInputDivideOptionTest();
    }

    //invalid calculator tests
    @Test
    @DisplayName("Invalid Addition Test - Variables As Input")
    @Tag("Invalid_Calculation_Test")
    void invalidAdditionOptionTest(){
        invalidCalculatorInputPlusOptionTest();
    }
}
