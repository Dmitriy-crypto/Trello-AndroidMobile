package com.telran.trello.tests;

import com.telran.trello.model.User;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
  @Test
  public void testLogin() throws InterruptedException {
    app.getSession().tapLoginButtonOnWelcomPage();
    app.getSession().fillLogInForm(new User().withUserName("rochmanelena").withPassword("12345.com"));
    app.getSession().tapLoginButton();
    app.getSession().confirmAtlassianLogin(new User().withUserName("rochman.elena@gmail.com").withPassword("12345.com"));
//
//        Assert.assertTrue(app.getPage().isTaskPresent());
  }


}
