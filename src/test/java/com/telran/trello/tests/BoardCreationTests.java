package com.telran.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
  @BeforeClass
  public void insurePreconditions() throws InterruptedException {
        //if(!app.getSession().isElementPresent(By.id(""))){
      app.getSession().login();
  //  }
  }

  @Test
  public void testBoardSwipe(){
    app.getPage().swipeUp();
    app.getPage().swipeUp();
    app.getPage().swipeUp();
    app.getPage().swipeUp();


  }
}
