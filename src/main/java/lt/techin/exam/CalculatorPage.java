package lt.techin.exam;

import org.openqa.selenium.JavascriptExecutor;
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

    //calculation history element
    @FindBy(xpath = "//li[@class='active']/a")
    private WebElement calculationHistoryLink;

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

    //result display element
    @FindBy(xpath = "//body/h4")
    private WebElement calculationResult;

    //invalid input error messages
    @FindBy(xpath = "//span[@id='sk1.errors']")
    private WebElement firstNumberInvalidInputMessage;
    @FindBy(xpath = "//span[@id='sk2.errors']")
    private WebElement secondNumberInvalidInputMessage;

   //input data
    private int number1;
    private int number2;

    //invalid input data
    private int negativeNumber1 = -3;
    private int negativeNumber2 = -6;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    //logout link click method
    public void clickLogOutLink(){logOutLink.click();}

    //calculator history link click
    public void clickCalculationHistoryLink(){calculationHistoryLink.click();}

    //data input methods

    //input data picker from generator
    public void inputData() {
        TestDataGenerator testDataGenerator = new TestDataGenerator(driver);

        number1 = testDataGenerator.generateRandomNumber1();
        number2 = testDataGenerator.generateRandomNumber2();

        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        logger.info("Generated data: " + "\n");
        logger.info("Number 1: " + number1);
        logger.info("Number 2: " + number2);
    }

    //valid data input methods
    public void inputNumberOne() {
        firstNumberInputField.clear();
        firstNumberInputField.sendKeys(String.valueOf(number1));}
    public void inputNumberTwo() {
        secondNumberInputField.clear();
        secondNumberInputField.sendKeys(String.valueOf(number2));}

    //invalid input methods (letters as variables)
    public void inputLettersIntoNum1InputField(){
        firstNumberInputField.clear();
        firstNumberInputField.sendKeys("AsD");}
    public void inputLettersIntoNum2InputField(){
        secondNumberInputField.clear();
        secondNumberInputField.sendKeys("BsD");}

    //invalid input data getter
    public void inputDataDivByZero() {
        TestDataGenerator testDataGenerator = new TestDataGenerator(driver);

        if (true) {
            // number1 has to be greater than zero for the 'division by zero'
            number1 = testDataGenerator.generateRandomNumber1();
            while (number1 == 0) {
                number1 = testDataGenerator.generateRandomNumber1();
            }
        }
        number2 = 0;

        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        logger.info("Generated data: " + "\n");
        logger.info("Number 1: " + number1);
        logger.info("Number 2: " + number2);
    }

    //invalid input method (divide by zero)
    public void inputZeroIntoNum2InputField(){secondNumberInputField.sendKeys(String.valueOf(0));}

    //invalid input method (negative numbers)
    public void inputNegativeNumberOne(){firstNumberInputField.sendKeys(String.valueOf(negativeNumber1));}



    //logical operators choice methods
    public void selectPlusOption() {plusOption.click();}
    public void selectTimesOption() {timesOption.click();}
    public void selectMinusOption() {minusOption.click();}
    public void selectDivideOption() {divideOption.click();}

    //count button click method
    public void clickCountButton() {countButton.click();}

    //web element assert methods
    public boolean isLogOutLinkDisplayed(){return logOutLink.isDisplayed();}
    public boolean isFirstNumberInputFieldDisplayed(){return firstNumberInputField.isDisplayed();}
    public boolean isSecondNumberInputFieldDisplayed(){return secondNumberInputField.isDisplayed();}
    public boolean isOperatorSelectorDisplayed(){return operatorSelector.isDisplayed();}

    //operator option asserts
    public boolean isPlusOperatorDisplayed(){return plusOption.isDisplayed();}
    public boolean isMinusOperatorDisplayed(){return minusOption.isDisplayed();}
    public boolean isTimesOperatorDisplayed(){return timesOption.isDisplayed();}
    public boolean isDivideOperatorDisplayed(){return divideOption.isDisplayed();}

    public boolean isCountButtonDisplayed(){return countButton.isDisplayed();}

    //logout success message getter
    public String getLogOutSuccessMessage(){return logOutSuccessMessage.getText();}

    //login confirmation text getter
    public String getLogInSuccessConfirmation(){return loginSuccess.getText();}

    //calculation result getter
    public String getCalculationResult(){
        String fullText = calculationResult.getText().trim();
        String[] parts = fullText.split("=");
        return parts[1].trim();
    }
    //input data getter
    public int getNumber1(){return number1;}
    public int getNumber2(){return number2;}

    //input field data getter (for negative tcs)

    public String getNumber1Values(){return firstNumberInputField.getAttribute("value");}
    public String getNumber2Values(){return secondNumberInputField.getAttribute("value");}

    //invalid input message getters
    public String getFirstNumberInvalidMessage(){return firstNumberInvalidInputMessage.getText();}
    public String getSecondNumberInvalidMessage(){return secondNumberInvalidInputMessage.getText();}
}
