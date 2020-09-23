package gzs.wx;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class action {
	WebDriver driver;
	@BeforeMethod
	  //执行test之前登录浏览器
	  public void Login()  {
		  System.setProperty("webdriver.chrome.driver","E:/webdri/chromedriver.exe");
		  	//System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/chromedriver.exe");
		driver = new ChromeDriver();
	  	
	  }

	
	/*
	 * //右键
	    *     右键点击百度一下按钮
	 */    
	@Test(enabled = false)
	  public void actionA() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  //找到百度一下按钮  su
		  WebElement web=driver.findElement(By.id("su"));
		  //实例化actions类
		  Actions act =new Actions(driver);
		  //百度一下  右键  传参数代表在当前元素位置下做右键，不传参数的话可能会在鼠标所在位置做右键或是左上角右键
		  act.contextClick(web).perform();
		  
		  
	  }	
	/*
	 * //双击按钮
	 *     
	 */    
	@Test(enabled = false)
	  public void actionB() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  //找到百度一下按钮  su
		  WebElement web=driver.findElement(By.id("su"));
		  //实例化actions类
		  Actions act =new Actions(driver);
		  //双击  若不传参数的话在鼠标当前的位置双击
		
		  act.doubleClick(web).perform();
		  
	  }	
	@Test(enabled = false)
	  public void actionC() throws InterruptedException {
		  driver.get("http://www.baidu.com");
		  //找到百度一下按钮  su
		  WebElement web=driver.findElement(By.id("su"));
		  //实例化actions类
		  Actions act =new Actions(driver);
		  //鼠标移动到按钮上
		act.moveToElement(web).perform();
		//获取鼠标移动到按钮后页面显示的文本
		String a= driver.findElement(By.xpath("")).getText();
		//校验
		 Assert.assertEquals(a, ""); 
		  
	  }	
	//元素拖动
	@Test(enabled = false)
	  public void actionD() throws InterruptedException {
		//打开某一网址
		  driver.get("http://www.baidu.com");
		  //找到该元素的id  su
		  WebElement web=driver.findElement(By.id("su"));
		  //实例化actions类
		  Actions act =new Actions(driver);
		  //拖动x=500;y=500的坐标轴上
		act.dragAndDropBy(web, 500, 500).perform();
		  
	  }	
	//元素拖动到另一个元素位置上
		@Test(enabled = false)
		  public void actionE() throws InterruptedException {
			//打开某一网址
			  driver.get("http://www.baidu.com");
			  //找到该元素的id  su
			  WebElement web1=driver.findElement(By.id("su"));
			  //第二个元素的定位位置
			  WebElement web2=driver.findElement(By.id("aa"));
			  //实例化actions类
			  Actions act =new Actions(driver);
			  //拖动到元素B位置上:点住图片-移动-释放鼠标-执行  
			  //该操作步骤是拖动到一个元素的中间
			act.clickAndHold(web1).moveToElement(web2).release(web1).perform();
			  
		  }	
		
		//
		//下拉框多选
				@Test(enabled = false)
				  public void actionF() throws InterruptedException {
					//打开某一网址
					  driver.get("http://www.baidu.com");
					  //找到下拉框的元素
					  WebElement web1=driver.findElement(By.id("su"));
					  //获取下拉框中的所有内容  \"//*[@id=\\\"s-top-left\\\"]/a[1]    下拉框中的第一个选项，后面的1去掉的话，可以根据list获取整个列表内容
					  List<WebElement> list = driver.findElements(By.xpath("\"//*[@id=\\\"s-top-left\\\"]/a"));
					  //实例化actions类
					  Actions act =new Actions(driver);
					  //按住SHIFT键 ，选择下拉框的第一个选项到第三个选项   ，放开SHIFT键， 执行    
					  //若只选第一个和第三个，把shift换成control  若第一个默认是选中的话，把get（0）去掉
					  act.keyDown(Keys.SHIFT)
					     .click(list.get(0))
					     .click(list.get(2))
					     .keyUp(Keys.SHIFT)
					     .perform();
					  
				  }	
				
				//ctrl+S保存网页
				@Test(enabled = false)
				  public void actionG() throws Exception {
					  //打开某一网址
					  driver.get("http://www.baidu.com");
					  //保存
					  Robot ro =new Robot();
					//按住control
					  ro.keyPress(KeyEvent.VK_CONTROL);
					  Thread.sleep(3000);
		/*
		 * //根据ascII码值按住s键 
		 * int keys=(int)new Character('S'); 
		 * System.out.println(keys);
		 * ro.keyPress(keys);
		 */
					//按住s
					  ro.keyPress(KeyEvent.VK_S);
					  //按住后需要进行释放
					//释放control
					  ro.keyRelease(KeyEvent.VK_CONTROL);
					//释放s
					  ro.keyRelease(KeyEvent.VK_S);
					  Thread.sleep(3000);
					  //按住回车
					  ro.keyPress(KeyEvent.VK_ENTER);
					  
					  
				  }	
				
				//文件上传下载
				@Test
				  public void actionH() throws Exception {
					//打开某一网址
					  driver.get("http://www.baidu.com");
					  //定位到上传按钮然后sendkeys
					  driver.findElement(By.id("su")).sendKeys("图片或文件位置");
  
				}
				
	 @AfterMethod(enabled = false)
	  //执行test之后关闭浏览器
	  public void close() {
		 //关闭浏览器
		 
		 driver.quit();
	  }
}
