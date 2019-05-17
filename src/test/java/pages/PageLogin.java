package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageLogin {

	private WebDriver driver;
	private By userField;
	private By passField;
	private By loginBtn;
	private By fields;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		
		userField = By.name("userName");
		passField = By.name("password");
		loginBtn = By.name("login");
		fields = By.tagName("input");
	}
	
	//Trabajo de Login
	
	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginBtn).click();
		/*File myScreenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenShotFile, new File("LOGIN " + System.currentTimeMillis()+".png"));
			} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			} */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void fields_login(String user, String pass) {
		List<WebElement> loginFields = driver.findElements(fields);
		loginFields.get(1).sendKeys(user);
		loginFields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		List<WebElement> loginFieldsElements = driver.findElements(fields);
		System.out.println(loginFieldsElements.size());
		Assert.assertTrue(loginFieldsElements.size()==5);
	}
	
}
