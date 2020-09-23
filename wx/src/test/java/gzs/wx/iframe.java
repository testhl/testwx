package gzs.wx;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframe {
	WebDriver driver;
	@BeforeMethod
	  //执行test之前登录浏览器
	  public void Login()  {
		  System.setProperty("webdriver.chrome.driver","E:/webdri/chromedriver.exe");
		  	//System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
		driver = new ChromeDriver();
	  	
	  }
    //	定位iframe控件中的内容
	
	@Test
	  public void iframe() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		 
		  //切换到frame内
		  //String类型的要传入name元素的值或者是id的值 假设id的值为su
		  driver.switchTo().frame("su");
		/*
		 * 若iframe中没有name或是id ;可以通过元素的方式转交控制权 当前页面只有一个iframe的情况下
		 * 
		 * WebElement web= driver.findElement(By.tagName("iframe"));
		 * driver.switchTo().frame(web);
		 */
		  //然后在点击frame框架内的按钮等等
		  driver.findElement(By.id("aa")).click();
	  }	

	/*
	 *  切换到ifame外
	 
	 */
	@Test
	  public void iframeB() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		 
		  //切换到frame内
		  //String类型的要传入name元素的值或者是id的值 假设id的值为su
		  driver.switchTo().frame("su");
		  //然后在点击frame框架内的按钮等等
		  driver.findElement(By.id("aa")).click();
		  //切换到iframe外，将控制权移交回来,将driver控制权转交到原来的页面
		  driver.switchTo().defaultContent();
		  driver.findElement(By.id("dd")).click();
		  
	  }	
	 @AfterMethod
	  //执行test之后关闭浏览器
	  public void close() {
		 //关闭浏览器
		 
		 driver.quit();
	  }
}
