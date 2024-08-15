package com.epam.training.AlionaSachok.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    protected void closeCookiesWindow () {
        new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(acceptButton))
                .click();
    }
}
