package gzs.wx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class select {
	WebDriver driver;
	@BeforeMethod
	  //执行test之前登录浏览器
	  public void Login()  {
		  System.setProperty("webdriver.chrome.driver","E:/webdri/chromedriver.exe");
		  	//System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * //全局等待 
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */
	  }

	/* 
	 * select标签处理
	 *
	 */
	@Test
	  public void iframeB() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		 WebElement web =driver.findElement(By.id(""));
		 //实例化select类
		 Select sel =new Select(web);
		 //根据索引获取
		 sel.selectByIndex(2);
		 //根据value=value1
		 sel.selectByValue("value1");
		 //根据文本值选择
		 sel.selectByVisibleText("文本值");
		 //等待
		 //先实例化WebDriverWait类，然后根据元素定位在进行定位等待
		 WebDriverWait wait=new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
		 
	  }	
	@AfterMethod
	  //执行test之后关闭浏览器
	  public void close() {
		 //关闭浏览器
		 
		 driver.quit();
	  }
}
