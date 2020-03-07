package com.telran.trello.manager;

import com.telran.trello.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionHelper extends HelperBase {


  public SessionHelper(AppiumDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void tapLoginButtonOnWelcomPage() {
    tap(By.id("log_in_button"));
  }

  public void fillLogInForm(User user)  {
    type(By.id("user"), user.getUserName());
    type(By.id("password"), user.getPassword());
    driver.hideKeyboard();
  }

  public void tapLoginButton() {
    tap(By.id("authenticate"));
//        tap(By.xpath("//*[contains(text(), 'LOGIN')]"));
  }

  public void confirmAtlassianLogin(User user) throws InterruptedException {

    new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("parentPanel")));
    WebElement popUp = driver.findElement(By.id("parentPanel"));
    popUp.findElement(By.xpath(".//*[@resource-id='android:id/button1']")).click();

    waitForElementAndTap(By.xpath("//*[@class='android.widget.Button'][@resource-id='android:id/button_once']"));
    pause(30000);

    if (!isElementPresent(By.id("username"))) {

      tap(By.xpath("//android.view.View[@content-desc='Add another account']"));
    }
    pause(20000);

    type(By.xpath("//*[@resource-id='username']"), user.getUserName() );
    tap(By.xpath("//android.widget.Button[@content-desc='Continue']"));
    pause(10000);
    type(By.xpath("//*[@resource-id='password']"), user.getPassword());
    driver.hideKeyboard();

    waitForElementAndTap(By.xpath("//*[@resource-id='login-submit']"));

  }

public  void login() throws InterruptedException {
 tapLoginButtonOnWelcomPage();
  fillLogInForm(new User().withUserName("rochmanelena").withPassword("12345.com"));
  tapLoginButton();
  confirmAtlassianLogin(new User().withUserName("rochman.elena@gmail.com").withPassword("12345.com"));
}


}
