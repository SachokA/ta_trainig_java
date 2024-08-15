package com.epam.training.AlionaSachok.Task1;

import org.openqa.selenium.WebDriver;

public class WebDriverInstance {
    private static WebDriverInstance instance;
    private WebDriver driver;
    private WebDriverInstance() {
    }
    public static WebDriverInstance driverInstance() {
        if (instance == null) {
            instance = new WebDriverInstance();
        }
        return instance;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public void setDriver(WebDriver webDriver) {
        this.driver = webDriver;
    }
}
