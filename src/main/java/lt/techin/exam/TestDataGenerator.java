package lt.techin.exam;

import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestDataGenerator extends BasePage{

    //random number generator
    private static final int MIN = 1;
    private static final int MAX = 2500;

    // Generator instance
    private Random random;

    // Input numbers
    private int num1;
    private int num2;

    public TestDataGenerator(WebDriver driver) {super(driver); this.random = new SecureRandom();}

    // Generate random numbers
    public int generateRandomNumber1() {num1 = random.nextInt((MAX - MIN) + 1) + MIN; return num1;}
    public int generateRandomNumber2() {num2 = random.nextInt((MAX - MIN) + 1) + MIN; return num2;}

    // Getters
    public int getNum1() { return num1; }
    public int getNum2() { return num2; }

    // username, password generator
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    private static final Random RANDOM = new SecureRandom();

    private static String userName;
    private static String password;

    // Generate random string methods
    private static String generateRandomString(String characters, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return String.join("", letters);
    }


    //generator methods
    private static String generateRandomNumberString(int length) {
        return generateRandomString(DIGITS, length);
    }

    private static String generateRandomSpecialString(int length) {
        return generateRandomString(SPECIAL, length);
    }

    // Randomizer methods
    public static String generateRandomUserName(int length) {
        return generateRandomString(UPPER + LOWER, length);
    }

    //random password generator
    public static String generateRandomPassword() {
        String numbers = "0123456789";
//        String special = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        // fixed password part
        String stokerPart = "Stoker";

        // random numeric sequence
        StringBuilder numericPart = new StringBuilder();
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append('_'); // Static underscore

        // shuffle the numeric part
        String shuffledNumericPart = shuffleString(numericPart.toString());

        //"Stoker" + shuffled numeric part
        StringBuilder password = new StringBuilder();
        password.append(stokerPart);
        password.append(shuffledNumericPart);

        return password.toString();
    }
    //getters for username / password

    public static String getUserName(){
        return userName;
    }




}
