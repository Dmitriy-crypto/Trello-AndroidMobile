package com.telran.trello.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends  HelperBase{
  public WelcomePage(AppiumDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public String getPageTitle() {
    return driver.findElement(By.xpath(
            "//*[@resource-id='com.trello:id/welcome_text']/*[@resource-id='com.trello:id/text']"))
            .getText();
  }

  public void swipeWelcomePageToLeft() {
    swipeToLeft(By.xpath("//*[@resource-id='com.trello:id/view_pager']"));
  }

  public boolean isLogInButtonPresent() {
    return isElementPresent(By.xpath("//*[@resource-id='com.trello:id/log_in_button']"));
  }

  public boolean isSignUpButtonPresent() {
    return isElementPresent(By.xpath("//*[@resource-id='com.trello:id/sign_up_button']"));

  }
}
