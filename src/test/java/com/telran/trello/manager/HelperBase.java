package com.telran.trello.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    AppiumDriver driver;
    WebDriverWait wait;

    public HelperBase(AppiumDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public  void waitForElementAndTap(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void type(By locator, String text) {
        waitForElement(locator);
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        TouchAction action = new TouchAction(driver);

        int x = size.width/2;

        int startY = (int) (size.height * 0.7);
        int stopY = (int) (size.height * 0.2);

        action
                .press(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();


    }

    public void swipeToLeft(By locator) {
        TouchAction action = new TouchAction(driver);
        WebElement element = driver.findElement(locator);

        int leftX = (int) (element.getLocation().getX() * 0.2);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY+lowerY)/2;

        action
                .press(PointOption.point(rightX, middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();


    }
}
