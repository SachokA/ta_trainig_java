package com.epam.training.AlionaSachok.Task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = "#postform-text")
    private WebElement textArea;
    @FindBy(css = "#select2-postform-expiration-container")
    private WebElement selectExpirationContainer;

    @FindBy(css = "#postform-name")
    private WebElement pastNameInput;
    @FindBy(xpath = "//button[contains(text(),'Create New Paste')]")
    private WebElement buttonCreateNewPaste;
    @FindBy(css = ".info-top h1")
    private  WebElement showTitleNewPaste;

    @FindBy(xpath = "//div[@class='source text']//div")
    private WebElement showTextNewPaste;

    @FindBy(css = ".source.bash")
    private WebElement sourceBashElement;
    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']/li")
    private List<WebElement> valuesExpirationSelect;

    @FindBy(css = "#select2-postform-format-container")
    private WebElement formatContainer;

    @FindBy(xpath = "//*[@class='left']/a[@class='btn -small h_800']")
    private WebElement showFormatHighlight;
    @FindBy(xpath = "//ul[@id='select2-postform-format-results']//li/ul/li")
    private List<WebElement> valuesFormatSelect;


    public void fillTextArea (String text) {
        textArea.clear();
        textArea.sendKeys(text);
    }

    public void openDropdownSelectExpiration() {
        selectExpirationContainer.click();
    }
    public void openDropdownSelectFormatHighlight() {
        formatContainer.click();
    }

    public void setTitle(String title) {
        pastNameInput.clear();
        pastNameInput.sendKeys(title);
    }
    public void setSelectFormatHighlight(String value) {
        List<WebElement> items = valuesFormatSelect;

        for (WebElement item:items) {
            if (item.getText().equals(value)) {
                item.click();
                return;
            }
        }
    }
    public void setSelectExpirationContainer(String value) {
        List<WebElement> items = valuesExpirationSelect;

        for (WebElement item:items) {
            if (item.getText().equals(value)) {
                item.click();
                return;
            }
        }
    }
    public void clickButtonCreateNewPaste() {
        buttonCreateNewPaste.click();
    }

    public PastFormResultPage createNewPaste(PasteFormOptions formOptions) {
        fillTextArea(formOptions.getPasteText());
        openDropdownSelectFormatHighlight();
        setSelectFormatHighlight(formOptions.getSyntaxHighlight());
        openDropdownSelectExpiration();
        setSelectExpirationContainer(formOptions.getPasteExpirationTime());
        setTitle(formOptions.getPasteTitle());
        clickButtonCreateNewPaste();
        return new PastFormResultPage();
    }

}
