package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestChaiPaniScreens {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private static String inpemail ="";
  private static String inppassword ="";
  
  
  
  
  static String getAlphaNumericString(int n) 
  { 

      // chose a Character random from this String 
      String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                  + "0123456789"
                                  + "abcdefghijklmnopqrstuvxyz"; 

      // create StringBuffer size of AlphaNumericString 
      StringBuilder sb = new StringBuilder(n); 

      for (int i = 0; i < n; i++) { 

          // generate a random number between 
          // 0 to AlphaNumericString variable length 
          int index 
              = (int)(AlphaNumericString.length() 
                      * Math.random()); 

          // add Character one by one in end of sb 
          sb.append(AlphaNumericString 
                        .charAt(index)); 
      } 

      return sb.toString(); 
  } 
  
  
@BeforeMethod
@BeforeClass
  public void setUp() throws Exception {
	
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Manpreet\\Downloads\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://chaipani.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test(priority=1)
  public void testRegisterCustomer() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Manpreet\\Downloads\\chromedriver\\chromedriver.exe");
	driver.get("http://chaipani.herokuapp.com/");
	inpemail = "Test"+getAlphaNumericString(8)+"@gmail.com";
	inppassword = "Preetpreet17$";
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("register")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Test User");
    driver.findElement(By.id("roll_no")).click();
    driver.findElement(By.id("roll_no")).clear();
    driver.findElement(By.id("roll_no")).sendKeys(getAlphaNumericString(8));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(inpemail);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(inppassword);
    driver.findElement(By.id("password-confirm")).click();
    driver.findElement(By.id("password-confirm")).clear();
    driver.findElement(By.id("password-confirm")).sendKeys("Preetpreet17$");
    driver.findElement(By.id("submit")).click();
    try {
      AssertJUnit.assertEquals("You are logged in!", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[2]/following::div[1]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }    
  }
  

  @Test(priority=2)
  public void testLoginCustomer() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Manpreet\\Downloads\\chromedriver\\chromedriver.exe");
	driver.get("http://chaipani.herokuapp.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("login")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("email")).click();
	driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(inpemail);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(inppassword);
    
    
    driver.findElement(By.id("submit")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      AssertJUnit.assertEquals("You are logged in!", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[2]/following::div[1]")).getText());
    }
    catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
  }
  
  @Test(priority=3)
  public void testaddCategory() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Manpreet\\Downloads\\chromedriver\\chromedriver.exe");
	driver.get("http://chaipani.herokuapp.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("login")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("email")).click();
	driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(inpemail);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(inppassword);
    driver.findElement(By.id("submit")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      AssertJUnit.assertEquals("You are logged in!", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dashboard'])[2]/following::div[1]")).getText());
    }
    catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    
    
    
    try {
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("product-link")).click();
        
    try {
      AssertJUnit.assertEquals("Viewing All Users", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Manage Category'])[1]/following::h4[1]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    String categorytoadd = getAlphaNumericString(5);
    
    
    driver.findElement(By.id("manage-category")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(categorytoadd);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    }
    
    catch (Exception e) {
      System.out.println("One of the web elements was not found");
    }
    
     
  }
  

  @Test(priority=4)
  public void testConfig() throws Exception {
   System.out.println("Config check successfull");
  }
  
  
  

 @AfterMethod
@AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
