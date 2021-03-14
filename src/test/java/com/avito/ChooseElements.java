package com.avito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.Encoder;
import utilities.WrongSiteException;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class ChooseElements {


    public static WebElement selectCategory() {
        return Driver.getDriver().findElement(AvitoElement.SELECT_CATEGORY.by);
    }

    public static void selectFromList(String string, WebElement webElement) {
        Select select = new Select(webElement);
        select.selectByValue(string);
    }

    public static WebElement printInSearchTextField() {
        return Driver.getDriver().findElement(AvitoElement.SEARCH_TEXT_FIELD.by);
    }

    public static WebElement clickChooseRegion() {
        return Driver.getDriver().findElement(AvitoElement.CHOOSE_REGION.by);
    }

    public static WebElement printInLocationTextField() {
        return Driver.getDriver().findElement(AvitoElement.LOCATION_TEXT_FIELD.by);
    }

    public static WebElement chooseFirstLocationOption() {
        return Driver.getDriver().findElement(AvitoElement.FIRST_LOCATION_OPTION.by);
    }

    public static WebElement clickShowResultsButton() {
        return Driver.getDriver().findElement(AvitoElement.SHOW_RESULTS_BUTTON.by);
    }

    public static WebElement clickCheckBoxWithPhoto() {
        return Driver.getDriver().findElement(AvitoElement.CHECKBOX_WITH_PHOTO.by);
    }

    public static void  checkIfSiteOpened(String string) throws UnsupportedEncodingException, WrongSiteException {
        if (Driver.getDriver().getCurrentUrl().contains(Encoder.encodeValue(string)));
        else throw new WrongSiteException("This is wrong site");
    }

    public static WebElement selectMoneyFilter() {
        return Driver.getDriver().findElement(AvitoElement.MONEY_FILTER.by);
    }

    public static void printNameANdPrice(int numberOfItems) {
        WebElement list = Driver.getDriver().findElement(AvitoElement.FIELD_WITH_PRODUCTS.by);
        List<WebElement> printersList = list.findElements(AvitoElement.PRODUCT_LIST.by);
        List<WebElement> priceList = list.findElements(AvitoElement.PRICE_LIST.by);
        System.out.printf("%-65s %-10s\n", "Printer", "Price");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.printf("%-65s %-10s\n", printersList.get(i).getText(), priceList.get(i).getText());
        }
    }
}

