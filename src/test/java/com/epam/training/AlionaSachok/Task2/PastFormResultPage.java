package com.epam.training.AlionaSachok.Task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastFormResultPage extends AbstractPage {
    @FindBy(css = ".info-top h1")
    private WebElement showTitleNewPaste;

    @FindBy(css = "ol.bash")
    private WebElement showTextNewPaste;

    @FindBy(xpath = "//*[@class='left']/a[@class='btn -small h_800']")
    private WebElement showFormatHighlight;


    public String getShowTitleNewPaste () {
        waitWebElementVisibilityOf(showTitleNewPaste);
        return showTitleNewPaste.getText();
    }

    public String getShowTextNewPaste () {
        return showTextNewPaste.getText();
    }

    public String getShowFormatHighlight () {return  showFormatHighlight.getText();}
}

