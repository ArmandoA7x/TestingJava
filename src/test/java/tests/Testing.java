package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Testing {
	private WebDriver driver; //el driver para navegar y hacer practicamente todo
	ArrayList<String> tabs; // se declara la arraylist tabs
	
	@BeforeMethod //tag de lo que se ejecuta antes de los tests
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); //se setea cual será el controlador, que está alojado en una carpeta llamada drivers que yo pusé ahí
		driver = new ChromeDriver(); //se instancia el objeto driver
		//driver.manage().window().maximize(); //maximiza la pantalla
		//driver.manage().window().fullscreen(); //pone en modo fullscreen la pantalla
		//driver.manage().window().setSize(new Dimension(800, 600)); //define el tamaño de la pantalla
		//driver.manage().window().setPosition(new Point(300, 200)); //define la posición de la pantalla
		driver.navigate().to("http://newtours.demoaut.com/"); // navega a el URL especificado
		Helpers helper = new Helpers(); //instancia el objeto de la clase Helpers para que pueda ser usado
		helper.sleepSeconds(3); //se utiliza helper con el metodo sleepSeconds para un delay de 3 segundos
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver; // se instancia y se castea una variable para hacer uso de scripts de Javascript
		String googleWindowString = "window.open('http://google.com')"; //se inicia una variable String que contiene un script de JS para abrir una nueva tap que navega a la url
		javascriptExecutor.executeScript(googleWindowString); //haciendo uso del objeto JS, se llama el metodo que ejecuta el script
		tabs = new ArrayList<String>(driver.getWindowHandles()); //complemento la arraylist con los handles
		
	}
	
	@Test
	public void pruebauno() { 
		WebDriverManager.setWindowSize(driver, "maximized");
		driver.switchTo().window(tabs.get(1)).navigate().to("http://www.youtube.com/user/dynoex"); //cambio de pagina y navego a una pagina en especifico
		driver.switchTo().window(tabs.get(0)); //cambio de pagina
		PageLogin pageLogin = new PageLogin(driver); //instancia objeto de la clase PageLogin
		pageLogin.login("user", "user"); //con el objeto se llama el metodo login y se le mandan parametros para ingresar a la pagina
		PageLogon pageLogon = new PageLogon(driver); //instancia objeto de la clase PageLogon
		pageLogon.assertLogonPage(); //con el objeto se llama el metodo assertLogonPage 
		
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
	
	@Test
	public void pruebaCantidadDeCampos() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			Screenshooter.takeScreen("Error", driver);
		}
		driver.switchTo().window(tabs.get(1)).close();
		driver.switchTo().window(tabs.get(0)).close();
	}
	
}
