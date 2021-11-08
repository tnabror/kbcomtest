package com.kitabisa.automation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverInit {

  public static WebDriver driver;

  public static void initialize() {
    //setup chromedriver
    WebDriverManager.chromedriver().setup();
    //initialize chrome options
    ChromeOptions options = new ChromeOptions();
    //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--start-maximized,--incognito");
    driver = new ChromeDriver(options);
    //for mac it --start-maximized not working properly. So need use this command to maximize
    driver.manage().window().maximize();
    //setting up implicit wait
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  public static void quit() {
    driver.quit();
  }

}
