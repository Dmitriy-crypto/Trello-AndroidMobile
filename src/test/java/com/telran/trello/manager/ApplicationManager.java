package com.telran.trello.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {

  AppiumDriver driver;
  WebDriverWait wait;

  SessionHelper session;
  TrelloPage page;
  WelcomePage welcome;

  public void init() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "qa22");
    capabilities.setCapability("platformVersion", "8.0");
    capabilities.setCapability("automationName", "Appium");
    capabilities.setCapability("appPackage", "com.trello");
    capabilities.setCapability("appActivity", ".home.HomeActivity");
    capabilities.setCapability("app",
            "C:/Users/Elena/Dropbox/Tel-ran/Mobile/apk/Trello_new.apk");

    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    wait = new WebDriverWait(driver, 20);
    session = new SessionHelper(driver, wait);
    page = new TrelloPage(driver, wait);
    welcome = new WelcomePage(driver, wait);
  }

  public SessionHelper getSession() {
    return session;
  }

  public TrelloPage getPage() {
    return page;
  }

  public void stop() throws InterruptedException {
    Thread.sleep(3000);
   // driver.quit();
  }

  public WelcomePage getWelcome() {
    return welcome;
  }
}
