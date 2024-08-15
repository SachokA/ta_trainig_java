package com.epam.training.AlionaSachok.Task2;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
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
    @CsvSource({ "'git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force',how to gain dominance among developers, 10 Minutes, Bash"})
    public void createNewPasteTest(String text, String title, String expiration, String formatHighlighting)  {
        PasteFormOptions formOptions = new PasteFormOptions(text,title,expiration,formatHighlighting);

        resultPage =  homePage.createNewPaste(formOptions);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(resultPage.getShowTitleNewPaste())
                .as("Expected title to be '%s' but was '%s'", title, resultPage.getShowTitleNewPaste())
                .isEqualTo(title);

        softAssertions.assertThat(AbstractPage.getMyTitle().contains(title))
                .as("Expected title '%s' to be contained in the page title but it was not", title)
                .isTrue();

        softAssertions.assertThat(resultPage.getShowTextNewPaste())
                .as("Expected text to be '%s' but was '%s'", text, resultPage.getShowTextNewPaste())
                .isEqualTo(text);

        softAssertions.assertThat(resultPage.getShowFormatHighlight())
                .as("Expected format highlighting to be '%s' but was '%s'", formatHighlighting, resultPage.getShowFormatHighlight())
                .isEqualTo(formatHighlighting);

        softAssertions.assertAll();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
