package com.teste.validacao;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CT03ValidarPaginaCheckout {
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
  public void testCT03ValidarPaginaCheckout() throws Exception {
    driver.get(baseUrl + "/");
	Thread.sleep(2000);
    // Fazendo a busca do produto
    driver.findElement(By.id("menuSearch")).click();
    driver.findElement(By.id("autoComplete")).clear();
    driver.findElement(By.id("autoComplete")).sendKeys("HP PAVILION 15T TOUCH LAPTOP");
    driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);
	Thread.sleep(2000);
    // Selecionando produto
    driver.findElement(By.id("1")).click();
	Thread.sleep(2000);
    assertEquals(driver.findElement(By.xpath("//div[@id='Description']/h1")).getText(), "HP PAVILION 15T TOUCH LAPTOP");
    // Alterando quantidade e cor do produto
    driver.findElement(By.xpath("(//span[@id='bunny'])[3]")).click();
    driver.findElement(By.cssSelector("div.plus")).click();
    driver.findElement(By.name("save_to_cart")).click();
    driver.findElement(By.id("menuCart")).click();
    assertEquals(driver.findElement(By.cssSelector("span.productColor[title=\"RED\"]")).getText(), "");
	Thread.sleep(2000);
    assertEquals(driver.findElement(By.xpath("//div[@id='shoppingCart']/table/tbody/tr/td[6]/p")).getText(), "$1,039.98");
    // Lipa dados salvos
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
