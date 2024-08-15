package com.epam.training.AlionaSachok.Task3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;
    private String originalWindow;
    private Double totalMonthlyPriceFromForm;

    @BeforeEach
    public void browserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void googleCloudPlatformPricingCalculator() throws InterruptedException {
        FormData formData = new FormData();
        formData.setProductName("Compute Engine");
        formData.setNumberOfInstances("4");
        formData.setOperatingSystemSoftware("free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license");
        formData.setMachineFamily("general-purpose");
        formData.setSeries("n1");
        formData.setMachineType("n1-standard-4");
        formData.setGpuType("nvidia-tesla-v100");
        formData.setNumberOfGPUs("1");
        formData.setLocalSSD("2x375 GB");
        formData.setRegion("europe-west4");
        GoogleCloudPricingCalculatorPage actualPricingResults = new GoogleCloudHomePage(driver)
                .openPage()
                .openPricingLink()
                .openPricingCalculator()
                .calculatePrice(formData)
                .clickShareButton();
        totalMonthlyPriceFromForm = actualPricingResults.getTotalMonthlyPrice();
        originalWindow = driver.getWindowHandle();
        actualPricingResults.switchEstimatePreviewPage();

        EstimatePreviewPage estimatePreviewPage = new EstimatePreviewPage(driver);
        estimatePreviewPage.switchNewWindows(originalWindow);
        List<String> listOfItems = estimatePreviewPage.getCalculatedValueFromForm();

        Assertions.assertEquals(totalMonthlyPriceFromForm, estimatePreviewPage.getTotalEstimate(listOfItems),
                "Issue in Total Estimated Cost: actual result is \n" + totalMonthlyPriceFromForm);
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

