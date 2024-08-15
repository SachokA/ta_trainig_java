package com.epam.training.AlionaSachok.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class EstimatePreviewPage extends AbstractPage {

    @FindBy(css = ".SeJRAd")
    List<WebElement> resultBlock;

    protected EstimatePreviewPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCalculatedValueFromForm() {
        waitWebElementVisibilityOfAll(resultBlock);
        List<String> calculatedFormText = new ArrayList<>();
        List<WebElement> calculatedForm = resultBlock;
        for (WebElement element : calculatedForm) {
            calculatedFormText.add(element.getText());
        }
        return calculatedFormText;
    }

    public static double calculateSumExcludingLast(List<String> elements) {
        double sum = 0.0;
        if (elements.size() <= 1) {
            return sum;
        }
        for (int i = 0; i < elements.size() - 1; i++) {
            String text = elements.get(i);
            if (!text.equalsIgnoreCase("N/A")) {
                try {
                    String cleanedText = text.replaceAll("[^\\d.,]", "");

                    cleanedText = cleanedText.replace(",", "");

                    double value = Double.parseDouble(cleanedText);
                    sum += value;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        return sum;
    }

    public double getTotalEstimate(List<String> list) {
        return calculateSumExcludingLast(list);
    }
}
