package com.teste.validacao;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CT04RemoverProdutosCarrinhoCompras {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private final String pathFirefoxDriver = "C:\\Selenium\\geckodriver.exe";

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", pathFirefoxDriver);
    driver = new FirefoxDriver();
	driver.manage().window().maximize();
    baseUrl = "https://advantageonlineshopping.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCT04RemoverProdutosCarrinhoCompras() throws Exception {
    driver.get(baseUrl + "/");
	Thread.sleep(2000);
    driver.findElement(By.linkText("SPECIAL OFFER")).click();
	Thread.sleep(2000);
    driver.findElement(By.id("see_offer_btn")).click();
	Thread.sleep(2000);
    driver.findElement(By.name("save_to_cart")).click();
    driver.findElement(By.id("menuCart")).click();
	Thread.sleep(2000);
    driver.findElement(By.linkText("REMOVE")).click();
	Thread.sleep(2000);
    assertEquals(driver.findElement(By.cssSelector("label.roboto-bold.ng-scope")).getText(), "Your shopping cart is empty");
    // ERROR: Caught exception [ERROR: Unsupported command [deleteAllVisibleCookies |  | ]]
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
