package gzs.wx;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class kongJian {
	WebDriver driver;

	@BeforeMethod
	// 执行test之前登录浏览器
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "E:/webdri/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "C:/Program Files
		// (x86)/chromedriver.exe");
		driver = new ChromeDriver();

	}

	// 打开浏览器、点击alert按钮，点击alert弹框中的确定按钮
	@Test
	public void alert() throws InterruptedException {
		driver.get("http://www.baidu.com");

		// 定位alert按钮元素然后点击 假设元素id为su
		driver.findElement(By.id("su")).click();
		// 将driver的控制权转交的alert（）弹框上
		// 一般弹框会弹出的比较慢，所以会加个等待
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		// 相当于点击弹窗中的确定按钮
		al.accept();

	}

	// 打开浏览器、点击confirm按钮，点击弹框中的取消按钮，取消后，又出现弹框点击确定
	@Test
	public void confrim() throws InterruptedException {
		driver.get("http://www.baidu.com");

		// 定位alert按钮元素然后点击 假设元素id为su
		driver.findElement(By.id("su")).click();
		// 将driver的控制权转交的alert（）弹框上
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		// 点击取消按钮
		al.dismiss();
		Thread.sleep(1000);
		al.accept();
	}

	// 打开浏览器、点击confirm按钮，弹框中输入值，点击确定按钮，出现确认弹出框，再次点击确认按钮
	@Test
	public void prompt() throws InterruptedException {
		driver.get("http://www.baidu.com");

		// 定位alert按钮元素然后点击 假设元素id为su
		driver.findElement(By.id("su")).click();
		// 将driver的控制权转交的alert（）弹框上
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		// 弹出框中输入相应的值
		al.sendKeys("123");
		Thread.sleep(1000);
		// 点击取消按钮
		al.accept();
		Thread.sleep(1000);
		al.accept();
	}

	// 打开浏览器、点击alert按钮，获取弹出框中的文本
	@Test
	public void text() throws InterruptedException {
		driver.get("http://www.baidu.com");

		// 定位alert按钮元素然后点击 假设元素id为su
		driver.findElement(By.id("su")).click();
		// 将driver的控制权转交的alert（）弹框上
		// 一般弹框会弹出的比较慢，所以会加个等待
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
		// 获取弹出框中的文本
		String text = al.getText();
		// 相当于点击弹窗中的确定按钮
		al.accept();
		Assert.assertEquals(text, "文本内容");
	}

	@AfterMethod
	// 执行test之后关闭浏览器
	public void close() {
		// 关闭浏览器

		driver.quit();
	}
}
