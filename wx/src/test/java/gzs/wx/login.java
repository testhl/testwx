package gzs.wx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	//登陆里面用到的元素
		//定位用户名称
	    public static By name=By.id("shortAccount");
	    //定位密码
	    public static By psw=By.id("password");
	    //定位点击登陆按钮
	    public static By click=By.xpath("//*[@id=\"loginForm\"]/div[6]/input");
	    
	public void loginIn(WebDriver driver,String phone,String password) {
		//获取手机号元素,输入手机号
				driver.findElement(name).sendKeys(phone);
				//输入密码
				driver.findElement(psw).sendKeys(password);
				//点击提交
				driver.findElement(click).click();
				//再输入验证码
				//在提交
	}
}
