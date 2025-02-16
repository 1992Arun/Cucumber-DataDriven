package org.step;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.utility.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition {

	public static WebDriver driver;

	public static String userName;

	public static String password;

	public static String[][] reader;


	@Given("I Open the Application URL in any supported browser")

	public void i_Open_the_Application_URL_in_any_supported_browser() throws IOException {

		ChromeOptions op = new ChromeOptions();

		op.addArguments("--incognito");

		op.addArguments("--headless");

		driver = new ChromeDriver(op);

		driver.get("https://tutorialsninja.com/demo/");

		reader = ExcelReader.reader(System.getProperty("user.dir")+"\\src\\test\\resources\\InputData.xlsx");

		//	CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Credentials.cs.csv"));
		//	
		//	List<String[]> readAll = reader.readAll();
		//	
		//	readAll.remove(0);
		//	
		//	for(int i=0; i<readAll.size();i++) {
		//	
		//	String[] strings = readAll.get(i);
		//	
		//	userName = strings[0];
		//	
		//	password = strings[1];



	}

	@When("I enter the username and password")
	public void i_enter_the_username_and_password() {

		for(int i=0;i<reader.length;i++) {

			userName= reader[i][0];

			password= reader[i][1];

			driver.findElement(By.cssSelector(".fa.fa-user")).click();

			driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

			driver.findElement(By.cssSelector("#input-email")).sendKeys(userName);

			driver.findElement(By.cssSelector("#input-password")).sendKeys(password);

			driver.findElement(By.cssSelector("#input-password")).submit();


		}



	}

	@Then("Verify that user should not login")
	public void verify_that_user_should_not_login() {

		Assert.assertTrue(driver.findElement(By.cssSelector("div[class^=alert]")).isDisplayed());
		
		driver.quit();
	}


}




