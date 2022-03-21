package challenge.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ChallengeAppiumTests {

	@SuppressWarnings("rawtypes")
	private AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeEach
	public void setUp() throws MalformedURLException {
		try {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "emulator-5554");
			desiredCapabilities.setCapability("automationName", "uiautomator2");
			desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
			desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

			URL remoteUrl = new URL("http://localhost:4723/wd/hub");

			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		} catch (Throwable e) {
			System.out.println("Error setUp: " + e.getMessage());
		}
	}

	@Test
	@Order(1)
	// Perform a Sum of 2 plus 2
	public void PerformSum() {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge PerformSum \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {
				
				//get digit_2 element
				MobileElement digit_2 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
				
				//perform a click on digit_2
				digit_2.click();
				
				//get plus element
				MobileElement plus = (MobileElement) driver.findElementByAccessibilityId("plus");
				
				//perform a click on digit_2
				plus.click();
				
				//perform a click on digit_2
				digit_2.click();
				
				//get result element
				MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

				// Validating that result exhibited is '4'
				assertEquals("4", result.getText());

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

			System.out.println("Error on Test createAccount: " + e.getMessage());

			assertTrue(false);
		}
	}

	@Test
	@Order(2)
	// Perform a Subtraction of 10 by 5
	public void PerformSubtraction() {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge PerformSubtraction \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {
				
				// get digit_1 element
				MobileElement digit_1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_1");
				
				//perform a click on digit_1
				digit_1.click();
				
				// get digit_0 element
				MobileElement digit_0 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_0");
				
				//perform a click on digit_0
				digit_0.click();
				
				// get minus element
				MobileElement minus = (MobileElement) driver.findElementByAccessibilityId("minus");
				
				//perform a click on minus
				minus.click();
				
				// get digit_5 element
				MobileElement digit_5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_5");
				
				//perform a click on digit_5
				digit_5.click();
				
				// get result element
				MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

				// Validating that result exhibited is '5'
				assertEquals("5", result.getText());

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

			System.out.println("Error on Test PerformSubtraction: " + e.getMessage());

			assertTrue(false);
		}
	}

	@Test
	@Order(3)
	// Perform a Multiplication of 5 times 20
	public void PerformMultiplication() {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge PerformMultiplication \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {

				// get digit_5 element
				MobileElement digit_5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_5");

				// perform a click at digit_5
				digit_5.click();

				// get multiply element
				MobileElement multiply = (MobileElement) driver.findElementByAccessibilityId("multiply");

				// perform a click at multiply
				multiply.click();

				// get digit_2 element
				MobileElement digit_2 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");

				// perform a click at digit_1
				digit_2.click();

				// get digit_0 element
				MobileElement digit_0 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_0");

				// perform a click at digit_0
				digit_0.click();

				// get result element
				MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

				// Validating that result exhibited is '100'
				assertEquals("100", result.getText());

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

			System.out.println("Error on Test PerformMultiplication: " + e.getMessage());

			assertTrue(false);
		}
	}

	@Test
	@Order(4)
	// Perform a division of 100 by 4
	public void PerformDivision() {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge PerformDivision \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {

				// get button_1 element
				MobileElement button_1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_1");

				// Perform a click at button_1
				button_1.click();

				// get button_0 element
				MobileElement button_0 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_0");

				// Perform a click at button_0
				button_0.click();

				// Perform a click at button_0
				button_0.click();

				// get button_divide element
				MobileElement button_divide = (MobileElement) driver.findElementByAccessibilityId("divide");

				// Perform a click at button_divide
				button_divide.click();

				// get button_4 element
				MobileElement button_4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_4");

				// Perform a click at button_4
				button_4.click();

				// get result element
				MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

				// Validating that result exhibited is '25'
				assertEquals("25", result.getText());

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

			System.out.println("Error on Test PerformDivision: " + e.getMessage());

			assertTrue(false);
		}
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
