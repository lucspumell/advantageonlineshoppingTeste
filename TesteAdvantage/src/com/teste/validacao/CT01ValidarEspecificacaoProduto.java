package com.teste.validacao;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CT01ValidarEspecificacaoProduto {
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
  public void testCT01ValidarEspecificacaoProduto() throws Exception {
    driver.get(baseUrl + "/");
	Thread.sleep(2000);
    driver.findElement(By.linkText("SPECIAL OFFER")).click();
	Thread.sleep(2000);
    driver.findElement(By.id("see_offer_btn")).click();
	Thread.sleep(2000);
    // Validando especificacoes
    assertEquals(driver.findElement(By.cssSelector("label.value.ng-binding")).getText(), "Simplicity");
    assertEquals(driver.findElement(By.xpath("//div[2]/label[2]")).getText(), "15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen");
    assertEquals(driver.findElement(By.xpath("//div[3]/label[2]")).getText(), "1920x1080");
    assertEquals(driver.findElement(By.xpath("//div[4]/label[2]")).getText(), "15.6");
    assertEquals(driver.findElement(By.xpath("//div[5]/label[2]")).getText(), "16GB DDR3 - 2 DIMM");
    assertEquals(driver.findElement(By.xpath("//div[6]/label[2]")).getText(), "Windows 10");
    assertEquals(driver.findElement(By.xpath("//div[7]/label[2]")).getText(), "AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics");
    assertEquals(driver.findElement(By.xpath("//div[8]/label[2]")).getText(), "Yes");
    assertEquals(driver.findElement(By.xpath("//div[9]/label[2]")).getText(), "5.51 lb");
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
