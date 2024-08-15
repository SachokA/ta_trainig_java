package com.epam.training.AlionaSachok.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;


public class WebDriverTest {
    private WebDriver driver;
    private static final String BASE_URL = "https://pastebin.com/";
    private HomePage homePage ;
    private PastFormResultPage resultPage;

    @BeforeEach
    public void setUp() {
        String browser = "chrome";
        driver = WebDriverFactory.createWebDriver(browser);
        driver.manage().window().maximize();
        WebDriverInstance.driverInstance().setDriver(driver);
        driver.get(BASE_URL);
        homePage = new HomePage();
        homePage.closeCookiesWindow();

    }
    @ParameterizedTest
    @CsvSource({"Hello from WebDriver, 10 Minutes, helloweb"})
    public void createNewPasteTest(String text, String expiration, String title) throws InterruptedException {
        PasteFormOptions formOptions = new PasteFormOptions(text,title,expiration);
        resultPage = homePage.createNewPaste(formOptions);

        Assertions.assertEquals(title,resultPage.getShowTitleNewPaste());
        Assertions.assertEquals(text,resultPage.getShowTextNewPaste());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
