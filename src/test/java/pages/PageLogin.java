package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {

	private WebDriver driver;
	private By userField;
	private By passField;
	private By loginBtn;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		
		userField = By.name("userName");
		passField = By.name("password");
		loginBtn = By.name("login");
	}
	
	//Trabajo de Login
	
	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginBtn).click();
		//Helpers helper = new Helpers();
		//helper.sleepSeconds(4);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
