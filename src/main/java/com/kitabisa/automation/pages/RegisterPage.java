package com.kitabisa.automation.pages;

import static com.kitabisa.automation.locator.RegisterLocator.BUTTON_REGISTER;
import static com.kitabisa.automation.locator.RegisterLocator.BUTTON_SAVE_PASSWORD;
import static com.kitabisa.automation.locator.RegisterLocator.BUTTON_VERIFICATION;
import static com.kitabisa.automation.locator.RegisterLocator.INPUT_EMAIL;
import static com.kitabisa.automation.locator.RegisterLocator.INPUT_FULL_NAME;
import static com.kitabisa.automation.locator.RegisterLocator.INPUT_OTP;
import static com.kitabisa.automation.locator.RegisterLocator.INPUT_PASSWORD;
import static com.kitabisa.automation.locator.RegisterLocator.INPUT_PASSWORD_CONFIRM;


public class RegisterPage extends com.kitabisa.automation.base.PageObject {

  public void openPage() {
    openUrl("https://accounts.kitabisa.com/register");
  }

  public void inputEmailOrPhone(String emailOrPhone) {
    type(INPUT_EMAIL, emailOrPhone);
  }

  public void inputFullName(String fullName) {
    type(INPUT_FULL_NAME, fullName);
  }

  public void clickButtonRegister() {
    click(BUTTON_REGISTER);
  }

  public boolean isButtonRegisterEnabled() {
    return find(BUTTON_REGISTER).isEnabled();
  }

  public void inputOTP(String otp) {
    type(INPUT_OTP, otp);
  }

  public void clickButtonVerification() {
    click(BUTTON_VERIFICATION);
  }

  public void inputPassword(String password) {
    type(INPUT_PASSWORD, password);
  }

  public void inputPasswordConfirmation(String passwordConfirmation) {
    type(INPUT_PASSWORD_CONFIRM, passwordConfirmation);
  }

  public void clickButtonSimpan(){
    click(BUTTON_SAVE_PASSWORD);
  }
}
