package gzs.wx;

import org.openqa.selenium.By;

public class loginpage {
	//登陆里面用到的元素
	//定位用户名称
    public static By name=By.id("shortAccount");
    //定位密码
    public static By psw=By.id("password");
    //定位点击登陆按钮
    public static By click=By.xpath("//*[@id=\"loginForm\"]/div[6]/input");
    
}
