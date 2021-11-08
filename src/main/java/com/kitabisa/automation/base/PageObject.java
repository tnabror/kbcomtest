package com.kitabisa.automation.base;

import com.kitabisa.automation.driver.WebDriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {

  //getDriver
  public WebDriver getDriver() {
    return WebDriverInit.driver;
  }

  //find
  public WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  //type
  public void type(By locator, String text) {
    WebElement element = find(locator);
    element.clear();
    element.sendKeys(text);
  }

  //click
  public void click(By locator) {
    find(locator).click();
  }

  //openURL
  public void openUrl(String url) {
    getDriver().get(url);
  }

}
