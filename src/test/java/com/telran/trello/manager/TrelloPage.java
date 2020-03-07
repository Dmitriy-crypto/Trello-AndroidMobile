package com.telran.trello.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloPage extends HelperBase {

    public TrelloPage(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isTaskPresent() {
        return isElementPresent(By.xpath("//*[contains(text(), 'Boards')]"));
    }
}
