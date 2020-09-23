package gzs.wx;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class NewTest {
	WebDriver driver;
	
  @BeforeMethod
  //执行test之前登录浏览器
  public void Login()  {
	  System.setProperty("webdriver.chrome.driver","E:/webdri/chromedriver.exe");
	  	//System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
	driver = new ChromeDriver();
  	
  }
  
  @Test(enabled = false)
  public void testA() throws InterruptedException {
	  driver.get("http://test.etpss.casicloud.com");
	  	Thread.sleep(1000);
  }
  
  @Test(enabled = false)
  //(enabled = false)意思为忽略改测试用例
  public void testB() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  	Thread.sleep(1000);
  }
  
  @Test(enabled = false)
  public void testBtagName() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  List<WebElement> list = driver.findElements(By.tagName("input"));
	  //findElements  返回的是list
	  System.out.println(list.size());
	  	Thread.sleep(1000);
  }
  @Test(enabled = false)
  public void testXpathList() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
	  //定位到id=s-top-left 下的所有a标签   获取a标签下的所有文本，并打印出来
	  System.out.println(list);
	  Thread.sleep(1000);
	  for(int i=0;i<list.size();i++) {
		  String text=list.get(i).getText();
		  System.out.println(text);  
	  }
	  
	  	Thread.sleep(1000);
  }
  @Test(enabled = false)
  public void testXpathListOne() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
	  System.out.println(list.size());
	  String text=list.get(2).getText();
	  System.out.println(text); 
	  Thread.sleep(1000);

  }
  
  //点击
  @Test(enabled = false)
  public void testClick() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  Thread.sleep(1000);
	  ////*[@id="s-top-left"]/a[1]
	  driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]")).click();
	  Thread.sleep(2000);
	  
	  //切换打开浏览器的页签
	  
	  Set<String> winHandels = driver.getWindowHandles();
	  //Thread.sleep(1000);
	 // System.out.println(winHandels.size());
	  List<String> list = new ArrayList<String>(winHandels);
	  //Thread.sleep(2000);
	 // System.out.println(list.size());
	  driver.switchTo().window(list.get(1));
	  Thread.sleep(1000);
	  
	  //获取当前页面的title
	  String title=driver.getTitle();
	  System.out.println(title);
	  //点击当前页签下的帮助
	  driver.findElement(By.xpath("//*[@id=\"sbox\"]/tbody/tr/td[2]/table/tbody/tr/td[2]/a")).click();
	  Assert.assertEquals(title, "百度新闻——海量中文资讯平台");
  }
  
  @Test(enabled = false)
  public void testGetTT() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  //获取标签元素
	  String tagname=driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[2]")).getTagName();
	  //获取value值
	  String va=driver.findElement(By.id("su")).getAttribute("value");
	  System.out.println(tagname);
	  System.out.println(va);
	  Assert.assertEquals(tagname, "a");
	  Assert.assertEquals(va, "百度一下");
  }
  
  @Test(enabled = false)
  public void isDisplayed() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	 
	  //获取当前元素是否完全展示
	  Boolean bo=driver.findElement(By.id("su")).isDisplayed();
	  
	  System.out.println(bo);
	  Assert.assertTrue(bo);
  }
  //遇到错误进行截图
  @Test
  public void shotPic()  {
	  driver.get("http://www.baidu.com");
	  
	  //((TakesScreenshot)driver)
	  //把当前的driver强制转换成TakesScreenshot类型，本来是webdriver类型
	  //OutputType.FILE文件输出流
	 File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 try {
		 //将文件copy到这个地址下
		FileUtils.copyFile(file, new File("E:\\pic\\1.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //该截图截的是当前窗口，不是整个页面，打开窗口的大小是多少截图就是多少
  }
  @AfterMethod
  //执行test之后关闭浏览器
  public void close() {
	 //关闭浏览器
	 
	 driver.quit();
  }
}
