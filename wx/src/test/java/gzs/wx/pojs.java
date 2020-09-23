package gzs.wx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class pojs {
	
	String url="https://www.baidu.com/";
	@Test
	public void testJs() throws InterruptedException {
		 System.setProperty("phantomjs.binary.path", "E:/driver/phantomjs.exe");
		 WebDriver driver =new PhantomJSDriver();
		driver.get(url);
		driver.findElement(By.id("kw")).sendKeys("测试");
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		String a=driver.getTitle();
		System.out.println(a);
	}
}
