package tests;

import base.appFactory;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utilities.excelFileReader;

import java.net.MalformedURLException;
import java.util.Random;

public class SignUpTest {

    SignUpPage signUp;
    appFactory factory;

    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        factory = new appFactory();
        appFactory.initializer();
        signUp = new SignUpPage();
        excelFileReader.readExcel();
    }

    @Test
    @Epic("Booking.com")
    @Feature("SignUp")
    @Description("Creating a new account for user")
    @Story("Testing signup for booking.com")
    @Severity(SeverityLevel.BLOCKER)
    public void createAccount() throws InterruptedException {
        Thread.sleep(5000);
        signUp.continue_with_email.click();
        String email = excelFileReader.getCellValue(1, 0);
        String pass = excelFileReader.getCellValue(1, 1);
        signUp.enterEmail("sk" + generateRandomNum() + email);
        Thread.sleep(5000);
        signUp.enter_password(pass);
    }

    @Step("generating random number")
    public int generateRandomNum() {
        Random random = new Random();
        int num = random.nextInt(900) + 100;
        return num;
    }
  @AfterTest
    public  void tearDown()
    {
        appFactory.quitDriver();
    }
}