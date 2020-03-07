package com.telran.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePageTest extends TestBase {
  @Test
  public void testSwipeWelcomePage() {
    System.out.println("Application opened");
    String firstPageTitle = app.getWelcome().getPageTitle();
    Assert.assertTrue(app.getWelcome().isLogInButtonPresent());
    Assert.assertTrue(app.getWelcome().isSignUpButtonPresent());

    app.getWelcome().swipeWelcomePageToLeft();
    String secondPageTitle = app.getWelcome().getPageTitle();

    Assert.assertTrue(app.getWelcome().isLogInButtonPresent());
    Assert.assertTrue(app.getWelcome().isSignUpButtonPresent());

    Assert.assertNotEquals(firstPageTitle, secondPageTitle);
  }
}
