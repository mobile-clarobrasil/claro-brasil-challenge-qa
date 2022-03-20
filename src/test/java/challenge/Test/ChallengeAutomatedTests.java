package challenge.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import challenge.Pages.BasePage;
import challenge.Support.Web;

public class ChallengeAutomatedTests {
	private WebDriver browser;
	private String random_email;

	public ChallengeAutomatedTests() {
		random_email = "gamecube" + BasePage.RandomValues() + "@hotmail.com";
	}

	// Initial tests setup
	@BeforeEach
	public void setUp() {
		try {
			// Local driver receives driver returning from Start Method
			browser = Web.Start();

			// Go to URL
			browser.get("http://automationpractice.com/");

			// Maximizing the window of browser
			browser.manage().window().maximize();

		} catch (Throwable e) {
			System.out.println("Error setUp: " + e.getMessage());
		}
	}

	@Test
	@Order(1)
	public void RealizarCadastro() throws Exception {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge RealizarCadastro \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {

				// Waiting to home page has completely loaded
				WebDriverWait wait_HomePageLoad = new WebDriverWait(browser, 10);
				wait_HomePageLoad
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_top_menu")));

				// Click on sign in button
				browser.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"))
						.click();

				// Waiting to authentication page load
				WebDriverWait wait_authenticationPageLoad = new WebDriverWait(browser, 10);
				wait_authenticationPageLoad.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page")));

				// Typing an email to create an account
				browser.findElement(By.id("email_create")).clear();
				browser.findElement(By.id("email_create")).sendKeys(random_email);

				// Just a click on create account button
				browser.findElement(By.cssSelector("#SubmitCreate")).click();

				// Waiting to personal information area until it's loaded
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

				// Just a click on register account button
				browser.findElement(By.cssSelector("#submitAccount")).click();

				// Waiting to my account page until it's loaded
				WebDriverWait wait_MyAccountPage = new WebDriverWait(browser, 10);
				wait_MyAccountPage.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));

				String Status = browser.findElement(By.className("info-account")).getAttribute("innerText");

				// Compare text from Status with an expected text at Page
				assertEquals(
						"Welcome to your account. Here you can manage all of your personal information and orders.",
						Status);

				// Thread.sleep(5000);

			});

			// BrowserStack Test 'passed' label
			// ((JavascriptExecutor) browser).executeScript(
			// "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\":
			// {\"status\":\"passed\"}}");

		} catch (Throwable e) {
			// BrowserStack Test 'failed' label
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\":
			// {\"status\":\"failed\"}}");

			System.out.println("Error Teste RealizarCadastro: " + e.getMessage());

			assertTrue(false);
		}

	}

	@Test
	@Order(2)
	public void RealizarLogin() throws Exception {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge RealizarLogin \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {

				// Waiting to home page has completely loaded
				WebDriverWait wait_HomePageLoad = new WebDriverWait(browser, 10);
				wait_HomePageLoad
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_top_menu")));

				// Click on sign in button
				browser.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"))
						.click();

				// Waiting to authentication page load
				WebDriverWait wait_authenticationPageLoad = new WebDriverWait(browser, 10);
				wait_authenticationPageLoad.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page")));

				// Typing - email
				browser.findElement(By.id("email")).clear();
				browser.findElement(By.id("email")).sendKeys("gamecube34534525@hotmail.com");

				// Typing - password
				browser.findElement(By.id("passwd")).clear();
				browser.findElement(By.id("passwd")).sendKeys("teste123");

				// Click on 'sign in' button
				browser.findElement(By.cssSelector("#SubmitLogin")).click();
				
				// Waiting to my account page until it's loaded
				WebDriverWait wait_MyAccountPage = new WebDriverWait(browser, 10);
				wait_MyAccountPage.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));

				String Status = browser.findElement(By.className("info-account")).getAttribute("innerText");

				// Compare text from Status with an expected text at Page
				assertEquals(
						"Welcome to your account. Here you can manage all of your personal information and orders.",
						Status);

				Thread.sleep(5000);

			});

			// BrowserStack Test 'passed' label
			// ((JavascriptExecutor) browser).executeScript(
			// "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\":
			// {\"status\":\"passed\"}}");

		} catch (Throwable e) {
			// BrowserStack Test 'failed' label
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\":
			// {\"status\":\"failed\"}}");

			System.out.println("Error Teste RealizarLogin: " + e.getMessage());

			assertTrue(false);
		}

	}

	// Quit browser method
	@AfterEach
	public void tearDown() {
		// Close Driver
		browser.quit();
	}
}