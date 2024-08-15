package com.epam.training.AlionaSachok.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private static final String DEFAULT_DROPDOWN_OPTION_XPATH = "//li[contains(@data-value,'%s')]";
    private static final String PRODUCT_NAME_XPATH = "//div[contains(@title, '%s')]";
    @FindBy(xpath = "//div[@class='QiFlid']//input")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//label[@class='gN5n4 MyvX5d D0aEmf']")
    private WebElement totalMonthPriceModal;
    @FindBy(xpath = "//span[@class='MyvX5d D0aEmf']")
    private WebElement totalMonthPrice;
    @FindBy(css = ".VfPpkd-aPP78e")
    private List<WebElement> dropdowns;
    @FindBy(xpath = "//label[text()='Regular']")
    private WebElement provisioningModelRegular;
    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;
    @FindBy(xpath = "//div[@class='message-container ']//span[@class='close']")
    private WebElement messageContainerCloseButton;
    @FindBy(xpath = "//a[@track-name='open estimate summary']")
    private WebElement openEstimateSummaryButton;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//ul[@aria-label='Series']/li")
    private List<WebElement> instanceSeriesOption;

    @FindBy(xpath = "//button//span[text()='Add to estimate']")
    private List<WebElement> addToEstimateButtons;
    @FindBy(xpath = "//div[@class='aHij0b-aGsRMb']/div[@data-idx='0']")
    private WebElement engineLink;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']/li[@data-value='2']")
    private WebElement localSSDValue2x375;
    @FindBy(xpath = "//li[@data-value='1']")
    private WebElement numberOfGPUs;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
        addToEstimateButtons.get(0).click();
        return this;
    }

    public void closeMessageContainerButton() {
        messageContainerCloseButton.click();
    }

    public GoogleCloudPricingCalculatorPage clickEngine() {
        waitElementToBeClickable(engineLink);
        engineLink.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clearAndFillNumberOfInstances(String value) {
        waitWebElementVisibilityOf(numberOfInstancesInput);
        numberOfInstancesInput.click();
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(value);
        return this;
    }


    public GoogleCloudPricingCalculatorPage calculatePrice(FormData formData) throws InterruptedException {
        goToTheMainForm();
        clearAndFillNumberOfInstances(formData.getNumberOfInstances());
        selectOperatingSystem(formData.getOperatingSystemSoftware());
        clickRegularOption();
        selectMachineFamily(formData.getMachineFamily());
        selectInstanceSeries(formData.getSeries());
        selectInstanceType(formData.getMachineType());
        closeMessageContainerButton();
        addGPUsCheckBox.click();
        selectGPUType(formData.getGpuType());
        selectOneNumberOfGPUs();
        selectLocalSSD2x375();
        selectDatacenterLocation(formData.getRegion());
        return this;
    }

    private void clickRegularOption() {
        waitElementToBeClickable(provisioningModelRegular);
        provisioningModelRegular.click();
    }

    public GoogleCloudPricingCalculatorPage goToTheMainForm() {
        clickAddToEstimateButton();
        clickEngine();
        waitInvisibilityOf(numberOfInstancesInput);
        return this;
    }

    public Double getTotalMonthlyPrice() {
        String price = totalMonthPrice.getText().replaceAll("[^\\d.,]", "");
        price = price.replaceAll(",", "");
        return Double.parseDouble(price);
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem(String operatingSystem) {
        dropdowns.get(3).click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, operatingSystem);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineFamily(String machineFamily) {
        dropdowns.get(4).click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, machineFamily);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceSeries(String series) {
        dropdowns.get(5).click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, series);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectInstanceType(String instanceType) {
        waitElementToBeClickable(dropdowns.get(6)).click();
        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, instanceType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String GPUType) {
        waitForSecond(Duration.ofSeconds(1));
        waitElementToBeClickable(dropdowns.get(7)).click();

        selectDropdownOption(DEFAULT_DROPDOWN_OPTION_XPATH, GPUType);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOneNumberOfGPUs() {
        waitElementToBeClickable(dropdowns.get(8)).click();
        jsScrollIntoView(numberOfGPUs);
        jsClick(numberOfGPUs);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickShareButton() {
        waitForSecond(Duration.ofSeconds(1));
        jsClick(shareButton);
        return this;
    }


    public GoogleCloudPricingCalculatorPage selectLocalSSD2x375() {
        waitElementToBeClickable(dropdowns.get(9)).click();
        jsScrollIntoView(localSSDValue2x375);
        localSSDValue2x375.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
        jsClick(dropdowns.get(10));
        WebElement element1 = driver.findElement(By.xpath("//ul[@aria-label='Region']/li[@data-value='" + datacenterLocation + "']"));
        jsScrollIntoView(element1);
        element1.click();
        return this;
    }

    public void clickOpenEstimatePreviewPage() {
//        waitInvisibilityOf(openEstimateSummaryButton);
       jsClick(openEstimateSummaryButton);
    }

    public EstimatePreviewPage switchEstimatePreviewPage() {
        clickOpenEstimatePreviewPage();
        return new EstimatePreviewPage(driver);
    }

}

