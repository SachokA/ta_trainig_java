package com.epam.training.AlionaSachok.Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    protected By acceptButton = By.xpath("//*[@class='cookie-button js-close-cookies']");

    public AbstractPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        return WebDriverInstance.driverInstance().getDriver();
    }
    public static void waitWebElementVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitWebElementVisibilityOfAll(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }
    public static String getMyTitle() {
        return getDriver().getTitle();
    }
    protected void closeCookiesWindow () {
        new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(acceptButton))
                .click();
    }
}
