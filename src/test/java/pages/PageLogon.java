package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {

	private WebDriver driver;
	private By xPath;
	public PageLogon(WebDriver driver) {
		this.driver = driver;
		
		xPath = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b");
	}
	
	public void assertLogonPage() {
		String contains = "Welcome back to";
		Assert.assertTrue(driver.findElement(xPath).getText().contains(contains));
	}
	
}
