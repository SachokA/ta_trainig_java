package com.epam.training.AlionaSachok.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String BASE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//a[contains(text(),'Pricing')]")
    private WebElement pricingLink;
    @FindBy(xpath = "//div[contains(text(),'Pricing calculator')]")
    private WebElement pricingCalculatorLink;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
    public GoogleCloudHomePage openPricingLink() {
        pricingLink.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openPricingCalculator() {
        pricingCalculatorLink.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
