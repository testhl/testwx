package gzs.wx;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class setdown {
	WebDriver driver;
	String url="https://eclipse.bluemix.net/packages/2020-06/";
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
	
	

	//文件下载  只能下载到默认路径
	@Test(enabled = false)
	  public void setDownA() throws InterruptedException, AWTException  {
		//打开某一网址
		  driver.get(url);
		  //定位到上传按钮然后sendkeys
		  driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[1]/center/table[2]/tbody/tr/td[1]/a")).click();
		  //键盘向下按钮选择保存文件
		  Robot ro =new Robot();
		  Thread.sleep(1000);
		  //对windows窗口选框进行向下操作
		  ro.keyPress(KeyEvent.VK_DOWN);
		/*
		 * //释放 
		 * Thread.sleep(1000); 
		 * ro.keyRelease(KeyEvent.VK_DOWN);
		 */
		  //点击windows选框的确定按钮
		  //点击键盘回车
		  Thread.sleep(1000);
		  ro.keyPress(KeyEvent.VK_ENTER);
		  
	}
	  
	  @Test
	  public void setDownB() throws InterruptedException, AWTException  {
		  FirefoxProfile ff =new FirefoxProfile();
		  ff.setPreference("browser.download.folderList", "2");
		  ff.setPreference("browser.download.dir","E:\\dd");
		  ff.setPreference("browser.helper", "");
		  driver = new FirefoxDriver(ff);
		  //打开某一网址
		  driver.get(url);
		  //定位到上传按钮然后sendkeys
		  driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[1]/center/table[2]/tbody/tr/td[1]/a")).click();
		 
		  
	}
	@AfterMethod(enabled = false)
	  //执行test之后关闭浏览器
	  public void close() {
		 //关闭浏览器
		 
		 driver.quit();
	  }
}
