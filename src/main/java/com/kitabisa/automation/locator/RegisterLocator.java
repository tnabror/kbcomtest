package com.kitabisa.automation.locator;

import org.openqa.selenium.By;

public interface RegisterLocator {

  By INPUT_EMAIL = By.cssSelector("[data-testid='register-input-email']");
  By INPUT_FULL_NAME = By.cssSelector("[data-testid='register-input-name']");
  By BUTTON_REGISTER = By.xpath("//button[contains(text(),'Daftar')]");

  By INPUT_OTP = By.cssSelector("[data-testid='input-otp']");
  By BUTTON_VERIFICATION = By.xpath("//button[contains(text(),'Verifikasi')]");

  By INPUT_PASSWORD = By.cssSelector("[data-testid='input-new-password']");
  By INPUT_PASSWORD_CONFIRM = By.cssSelector("[data-testid='input-confirmation-password']");
  By BUTTON_SAVE_PASSWORD = By.xpath("//button[contains(text(),'Simpan')]");
}
