package com.kitabisa.automation;

import com.kitabisa.automation.driver.WebDriverInit;
import com.kitabisa.automation.pages.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Web {

  @Before
  public void initializeWebdriver() {
    WebDriverInit.initialize();
  }

  @After
  public void quitWebDriver() throws InterruptedException {
    Thread.sleep(1000);
    WebDriverInit.quit();
  }

  RegisterPage registerPage = new RegisterPage();

  @Test
  public void verifyUserCanNotRegisterWhenInputNotAllowedInputField(){
    registerPage.openPage();

    //valid phone & invalid name
    registerPage.inputEmailOrPhone("621234567");
    registerPage.inputFullName("Tri 123");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    registerPage.inputEmailOrPhone("081234567");
    registerPage.inputFullName(".' ///");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    //valid email & invalid name
    registerPage.inputEmailOrPhone("tri.abror@gmail.com");
    registerPage.inputFullName("Tri 123");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    registerPage.inputEmailOrPhone("tri.abror@gmail.com");
    registerPage.inputFullName(".' ///");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    //invalid phone & valid name
    registerPage.inputEmailOrPhone("1234712312312312");
    registerPage.inputFullName("Tri Abror");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    registerPage.inputEmailOrPhone("08123456");
    registerPage.inputFullName("Tri .'");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    //invalid email & valid name
    registerPage.inputEmailOrPhone("tri.abror@ gmail.com");
    registerPage.inputFullName("Tri Abror");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    //invalid phone & invalid name
    registerPage.inputEmailOrPhone("62123456");
    registerPage.inputFullName("Tri 123");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());

    //invalid email & invalid name
    registerPage.inputEmailOrPhone("tri.abror@ gmail.com");
    registerPage.inputFullName("Tri 123");
    Assert.assertFalse(registerPage.isButtonRegisterEnabled());
  }

  //this test maybe can only running on lower env, because always got browser check human
  @Test
  public void verifyUserIsAbleToRegisterButNotVerified() throws InterruptedException {
    registerPage.openPage();

    registerPage.inputEmailOrPhone("testkitabisa@gmail.com");
    registerPage.inputFullName("Tri KK");
    registerPage.clickButtonRegister();

    registerPage.inputOTP(getOTPFromSomeWhere());
    registerPage.clickButtonVerification();

    registerPage.inputPassword(RandomStringUtils.randomAlphanumeric(8));
    registerPage.inputPasswordConfirmation(RandomStringUtils.randomAlphanumeric(8));
    registerPage.clickButtonSimpan();

    //assert something that verify user successfull register
    //i got error message until this steps
    //get error terjadi kesalahan, so i can continue making automation assertion
  }

  //get otp using internal api if possible
  public static String getOTPFromSomeWhere(){
    return RandomStringUtils.randomNumeric(6);
  }
}
