package gzs.wx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class wxXq {
	WebDriver driver;
	String url="http://etpss.casicloud.com/home/gyl/inquiry/wx/publish.html";
	
	@BeforeMethod
	  //执行test之前登录浏览器
	  public void Login()  {
		  System.setProperty("webdriver.chrome.driver","E:/webdri/chromedriver.exe");	  	
		  driver = new ChromeDriver();	
	  }
	@DataProvider(name="A")
	public Object[][] wxInquiry_B() {
		return new Object[][] {
			{"15910000001","123456"},{"15910000002","123456"}
		};
	}
	@Test(dataProvider="A")
	public void wxInquiry(String u,String p) throws InterruptedException {
		/*
		 * 实例化time类调用里面的方法
		 * time t=new time(); 
		 * String tt1= t.timeA(); 
		 * driver.get(url);
		 * driver.findElement(By.id("shortAccount")).sendKeys(tt1);
		 */
		//访问发布需求网址
		driver.get(url);
        login lo =new login();
		lo.loginIn(driver,u,p);
		
		//登陆成功后填写内容
		
	}
	
	
	@AfterMethod
	  //执行test之后关闭浏览器
	  public void close() {
		 //关闭浏览器
		 driver.quit();
	  }
}
