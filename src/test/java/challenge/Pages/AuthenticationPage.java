package challenge.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePage{
	public AuthenticationPage(WebDriver browser) {
		super(browser);
		
		// Waiting to authentication page load
		WebDriverWait wait_authenticationPageLoad = new WebDriverWait(browser, 10);
		wait_authenticationPageLoad.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page")));
	}
	
	// Typing an email to create an account
	public AuthenticationPage TypingEmail() {
		browser.findElement(By.id("email_create")).clear();
		browser.findElement(By.id("email_create")).sendKeys("gamecube"+BasePage.RandomValues()+"@hotmail.com");

		return this;
	}
	
	// Just a click on create account button
	public AuthenticationPage ClickCreateAccount() {
		
		// Just a click on create account button
		browser.findElement(By.cssSelector("#SubmitCreate")).click();
		
		return this;
	}
	
	//Method to type and enter with all the user personal data
	public AuthenticationPage EnteringPersonalData() {
		// Waiting to personal information DIV until it's loaded
		WebDriverWait wait_personalInformationDiv = new WebDriverWait(browser, 10);
		wait_personalInformationDiv.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#account-creation_form > div:nth-child(1) > h3")));

		// Selecting gender
		browser.findElement(By.cssSelector("#id_gender1")).click();

		// Typing first name
		browser.findElement(By.id("customer_firstname")).clear();
		browser.findElement(By.id("customer_firstname")).sendKeys("Rodrigo");

		// Typing last name
		browser.findElement(By.id("customer_lastname")).clear();
		browser.findElement(By.id("customer_lastname")).sendKeys("Rosa");

		// Typing password
		browser.findElement(By.id("passwd")).clear();
		browser.findElement(By.id("passwd")).sendKeys("teste123");

		// Picking a day
		Select selectElementDay = new Select(browser.findElement(By.id("days")));
		selectElementDay.selectByValue("30");

		// Picking a month
		Select selectElementMonth = new Select(browser.findElement(By.id("months")));
		selectElementMonth.selectByValue("12");

		// Picking a year
		Select selectElementYear = new Select(browser.findElement(By.id("years")));
		selectElementYear.selectByValue("1995");

		// Typing first name - address
		browser.findElement(By.id("firstname")).clear();
		browser.findElement(By.id("firstname")).sendKeys("Rodrigo");

		// Typing last name - address
		browser.findElement(By.id("lastname")).clear();
		browser.findElement(By.id("lastname")).sendKeys("Rosa");

		// Typing - company
		browser.findElement(By.id("company")).clear();
		browser.findElement(By.id("company")).sendKeys("teste");

		// Typing - address
		browser.findElement(By.id("address1")).clear();
		browser.findElement(By.id("address1")).sendKeys("Rua ironNow");

		// Typing - city
		browser.findElement(By.id("city")).clear();
		browser.findElement(By.id("city")).sendKeys("Austin");

		// Picking a state
		Select selectElementState = new Select(browser.findElement(By.id("id_state")));
		selectElementState.selectByValue("43");

		// Typing - post code
		browser.findElement(By.id("postcode")).clear();
		browser.findElement(By.id("postcode")).sendKeys("73301");

		// Picking a country
		Select selectElementcountry = new Select(browser.findElement(By.id("id_country")));
		selectElementcountry.selectByValue("21");

		// Typing - phone
		browser.findElement(By.id("phone_mobile")).clear();
		browser.findElement(By.id("phone_mobile")).sendKeys("5512996299999");

		// Typing - alias
		browser.findElement(By.id("alias")).clear();
		browser.findElement(By.id("alias")).sendKeys("My Address");
		
		return this;
		
	}
	
	// Just a click on register account button
	public MyAccountPage ClickRegisterButton() {
		
		browser.findElement(By.cssSelector("#submitAccount")).click();
		
		return new MyAccountPage(browser);
	}
	
	// Typing - user's email and password
	public AuthenticationPage TypingLoginData() {
		
		// Typing - email
		browser.findElement(By.id("email")).clear();
		browser.findElement(By.id("email")).sendKeys("gamecube34534525@hotmail.com");

		// Typing - password
		browser.findElement(By.id("passwd")).clear();
		browser.findElement(By.id("passwd")).sendKeys("teste123");
		
		return this;
	}
	
	// Just a click on 'sign in' button
	public MyAccountPage ClickSignInButton() {
	
		browser.findElement(By.cssSelector("#SubmitLogin")).click();
		
		return new MyAccountPage(browser);
	}
	
}
