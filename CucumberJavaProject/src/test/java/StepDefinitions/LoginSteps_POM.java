package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginSteps_POM {

	WebDriver driver;
	LoginPage login;
	
	@SuppressWarnings("deprecation")
	@Given("Browser is open")
	public void browser_is_open() {
		
		System.out.println("---------- I am inside LoginStep_POM----------");
		
		System.out.println("Inside Step-browser is open"); 
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		   driver.manage().window().maximize();
	}
	@And("user is on login page")
	public void user_is_on_login_page() {
		
		
		driver.get("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) throws InterruptedException {
	
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		
	//	driver.findElement(By.id("name")).sendKeys(username);
		Thread.sleep(1000);
		//driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
	}
	@And("user clicks on login")
	 public void user_clicks_on_login() throws InterruptedException {
		login.clickLogin();
		
	   // driver.findElement(By.id("login")).click();
	    Thread.sleep(2000);
	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() throws InterruptedException {
	    driver.findElement(By.id("country")).sendKeys("India");
	    Thread.sleep(2000);
	    driver.findElement(By.id("address")).sendKeys("ara");
	    Thread.sleep(2000);
	    driver.findElement(By.id("email")).sendKeys("mdimranzama3110@gmail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("phone")).sendKeys("7061651398");
	    Thread.sleep(2000);
	    driver.findElement(By.id("save")).click();
	    Thread.sleep(2000);
	    login.LogoutDisplay();
	//	driver.findElement(By.id("logout")).isDisplayed();
	    
	    driver.close();
	    Thread.sleep(2000);
	    driver.quit();
	}
}
