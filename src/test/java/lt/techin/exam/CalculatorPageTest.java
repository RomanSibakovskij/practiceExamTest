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
    @Tag("Letters_As_Variables")
    void invalidAdditionOptionLettersTest(){
        invalidCalculatorInputPlusOptionTest();
    }

    @Test
    @DisplayName("Invalid Subtraction Test - Variables As Input")
    @Tag("Invalid_Calculation_Test")
    @Tag("Letters_As_Variables")
    void invalidSubtractionOptionLettersTest(){
        invalidCalculatorInputMinusOptionTest();
    }

    @Test
    @DisplayName("Invalid Multiplication Test - Variables As Input")
    @Tag("Invalid_Calculation_Test")
    @Tag("Letters_As_Variables")
    void invalidMultiplicationOptionLettersTest(){
        invalidCalculatorInputTimesOptionTest();
    }

    @Test
    @DisplayName("Invalid Division Test - Variables As Input")
    @Tag("Invalid_Calculation_Test")
    @Tag("Letters_As_Variables")
    void invalidDivisionOptionLettersTest(){
        invalidCalculatorInputDivideOptionTest();
    }

    @Test
    @DisplayName("Invalid Division Test - Division By Zero")
    @Tag("Invalid_Calculation_Test")
    @Tag("Divide_By_Zero")
    void invalidDivisionOptionByZeroTest(){
        invalidCalculatorInputDivideOptionByZeroTest();
    }

    @Test
    @DisplayName("Invalid Addition Test - Add Negative Number 1 To Number 2")
    @Tag("Invalid_Calculation_Test")
    @Tag("Negative_Number_One_Addition")
    void invalidAdditionOptionNegativeNumOneTest(){
        invalidInputNegativeNumberOnePlusOptionTest();
    }

    @Test
    @DisplayName("Invalid Addition Test - Subtract From Negative Number 1 Number 2")
    @Tag("Invalid_Calculation_Test")
    @Tag("Negative_Number_One_Subtraction")
    void invalidSubtractionOptionNegativeNumOneTest(){
        invalidInputNegativeNumberOneMinusOptionTest();
    }

    @Test
    @DisplayName("Invalid Addition Test - Multiply Negative Number 1 Onto Number 2")
    @Tag("Invalid_Calculation_Test")
    @Tag("Negative_Number_One_Multiplication")
    void invalidMultiplicationOptionNegativeNumOneTest(){
        invalidInputNegativeNumberOneTimesOptionTest();
    }

    @Test
    @DisplayName("Invalid Addition Test - Divide Negative Number 1 By Number 2")
    @Tag("Invalid_Calculation_Test")
    @Tag("Negative_Number_One_Division")
    void invalidDivisionOptionNegativeNumOneTest(){
        invalidInputNegativeNumberOneDivideOptionTest();
    }
}
