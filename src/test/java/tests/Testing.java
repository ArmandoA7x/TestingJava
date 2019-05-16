package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Testing {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		Helpers helper = new Helpers();
		helper.sleepSeconds(4);
	}
	
	@Test
	public void pruebauno() { 
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("user", "user");
		PageLogon pageLogon = new PageLogon(driver);
		pageLogon.assertLogonPage();
	}
	
	@Test
	public void pruebaDos() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("mercury", "mercury");
		PageReservation pageReservation = new PageReservation(driver);
		pageReservation.assertPage();
	}
	
	@Test
	public void pruebaTres() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.login("mercury", "mercury");
		PageReservation pageReservation = new PageReservation(driver);
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("London");
		Helpers helper = new Helpers();
		helper.sleepSeconds(2);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
