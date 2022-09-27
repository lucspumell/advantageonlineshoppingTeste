package com.teste.validacao;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CT02ValidarAlteracaoCorProdutoCarrinho {
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
  public void testCT02ValidarAlteracaoCorProdutoCarrinho() throws Exception {
    driver.get(baseUrl + "/");
	Thread.sleep(2000);
    driver.findElement(By.linkText("SPECIAL OFFER")).click();
	Thread.sleep(2000);
    driver.findElement(By.id("see_offer_btn")).click();
	Thread.sleep(2000);
    // Selecionando cor Vermelha
    driver.findElement(By.xpath("(//span[@id='bunny'])[5]")).click();
    driver.findElement(By.name("save_to_cart")).click();
    driver.findElement(By.id("menuCart")).click();
	Thread.sleep(2000);
    assertEquals(driver.findElement(By.cssSelector("span.productColor[title=\"RED\"]")).getText(), "");
    // Limpa dados salvos
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
