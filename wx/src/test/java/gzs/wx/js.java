package gzs.wx;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class js {
	WebDriver driver;
	String url="https://www.baidu.com/";
	@BeforeMethod
	  //执行test之前登录浏览器
	  public void Login()  {
		  System.setProperty("webdriver.firefox.driver", "E:/driver/geckodriver.exe");
		  System.setProperty("webDriver.firefox.bin","F:/MozillaFirefox/firefox.exe");	 
		  driver = new FirefoxDriver();
		  
		/*
		 * System.setProperty("webdriver.chrome.driver", "E:/driver/chromedriver.exe");
		 * driver = new ChromeDriver();
		 */
	  }
	@Test
	public void testJs() throws InterruptedException {
		driver.get(url);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"软件测试\");");
		Thread.sleep(2000);
	}
	@AfterMethod
	  //执行test之后关闭浏览器
	  public void close() {
		 //关闭浏览器
		 
		 driver.quit();
	  }
}
