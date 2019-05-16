package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {
	
	private WebDriver driver;
	private By xPath;
	private By passengersDrop;
	private By fromDrop;
	private By toDrop;

	public PageReservation(WebDriver driver) {
		this.driver = driver;
		
		xPath = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		passengersDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
	}
	
	public void assertPage() {
		String contains = "Flight Finder to search";
		Assert.assertTrue(driver.findElement(xPath).getText().contains(contains));
	}
	
	public void selectPassengers(int cant) {
		WebDriverWait wait = new WebDriverWait(driver,10); //esperar a que aparezca y continuar
		WebElement cantPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
		Select selectPasajeros = new Select(cantPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}
	
}
