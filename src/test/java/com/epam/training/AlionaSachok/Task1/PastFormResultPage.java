package com.epam.training.AlionaSachok.Task1;

import com.epam.training.AlionaSachok.Task1.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastFormResultPage extends AbstractPage {
    @FindBy(css = ".info-top h1")
    private WebElement showTitleNewPaste;

    @FindBy(xpath = "//div[@class='source text']//div")
    private WebElement showTextNewPaste;

    @FindBy(xpath = "//*[@class='left']/a[@class='btn -small h_800']")
    private WebElement showFormatHighlight;


    public String getShowTitleNewPaste () {
        waitWebElementVisibilityOf(showTitleNewPaste);
        return showTitleNewPaste.getText();
    }

    public String getShowTextNewPaste () {
        waitWebElementVisibilityOf(showTextNewPaste);
        return showTextNewPaste.getText();
    }

    public String getShowFormatHighlight () {return  showFormatHighlight.getText();}
}
