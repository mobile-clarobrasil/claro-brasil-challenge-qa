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
import io.appium.java_client.ios.IOSDriver;

public class ChallengeAppiumTests {

	@SuppressWarnings("rawtypes")
	//private AndroidDriver driver;
	private IOSDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeEach
	public void setUp() throws MalformedURLException {
		try {
			/*DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "emulator-5554");
			desiredCapabilities.setCapability("automationName", "uiautomator2");
			desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
			desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");*/
			
			
			
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("app", "/Users/rodrigolopes/Desktop/SimpleCalculator.app");
		    desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
		    desiredCapabilities.setCapability("udid", "BE891D50-E3C0-4D9C-8922-0A6A9B6705A2");
		    desiredCapabilities.setCapability("platformName", "ios");
		    desiredCapabilities.setCapability("platformVersion", "14.4");
		    desiredCapabilities.setCapability("showXcodeLog", true);
		    desiredCapabilities.setCapability("includeSafariInWebviews", true);
			

			URL remoteUrl = new URL("http://localhost:4723/wd/hub");

			//driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			driver = new IOSDriver(remoteUrl, desiredCapabilities);
		} catch (Throwable e) {
			System.out.println("Error setUp: " + e.getMessage());
		}
	}
	

	@Test
	@Order(1)
	// Perform a Sum of 10 plus 20
	public void PerformSum() {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge PerformSum \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {
				
				
				//get first_input element
				MobileElement first_input = (MobileElement) driver.findElementByAccessibilityId("apple_first_input");
				
				//type a value on first_input
				first_input.sendKeys("10");
				
				//get second_input element
			    MobileElement second_input = (MobileElement) driver.findElementByAccessibilityId("apple_second_input");
			    
			    //type a value on second_input
			    second_input.sendKeys("20");
			    
			    //get sum_button element
			    MobileElement sum = (MobileElement) driver.findElementByAccessibilityId("apple-sum-button");
			    
			    //perform a click on sum_button element
			    sum.click();
			    
			    //get result text element
			    MobileElement result_text = (MobileElement) driver.findElementByAccessibilityId("apple_result_text");
				
			    //Validating that result exhibited is '30'
				assertEquals("30", result_text.getText());
				
				
				
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

			System.out.println("Error on Test PerformSum: " + e.getMessage());

			assertTrue(false);
		}
	}

	@Test
	@Order(2)
	// Perform a Subtraction of 20 by 5
	public void PerformSubtraction() {
		try {
			// BrowserStack Setting name of test
			// JavascriptExecutor jse = (JavascriptExecutor) browser;
			// jse.executeScript(
			// "browserstack_executor: {\"action\": \"setSessionName\", \"arguments\":
			// {\"name\":\" Challenge PerformSubtraction \" }}");

			// test will fail if run lasts more than 5 minutes
			Assertions.assertTimeoutPreemptively(Duration.ofMinutes(5), () -> {
				
				//get first_input element
				MobileElement first_input = (MobileElement) driver.findElementByAccessibilityId("apple_first_input");
				
				//type a value on first_input
				first_input.sendKeys("20");
				
				//get second_input element
			    MobileElement second_input = (MobileElement) driver.findElementByAccessibilityId("apple_second_input");
			    
			    //type a value on second_input
			    second_input.sendKeys("5");
			    
			    //get subtract-button element
			    MobileElement subtract = (MobileElement) driver.findElementByAccessibilityId("apple-subtract-button");
			    
			    //perform a click on subtract_button element
			    subtract.click();
			    
			    //get result text element
			    MobileElement result_text = (MobileElement) driver.findElementByAccessibilityId("apple_result_text");
				
			    //Validating that result exhibited is '15'
				assertEquals("15", result_text.getText());

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

				//get first_input element
				MobileElement first_input = (MobileElement) driver.findElementByAccessibilityId("apple_first_input");
				
				//type a value on first_input
				first_input.sendKeys("20");
				
				//get second_input element
			    MobileElement second_input = (MobileElement) driver.findElementByAccessibilityId("apple_second_input");
			    
			    //type a value on second_input
			    second_input.sendKeys("5");
			    
			    //get multiply-button element
			    MobileElement multiply = (MobileElement) driver.findElementByAccessibilityId("apple-multiply-button");
			    
			    //perform a click on multiply_button element
			    multiply.click();
			    
			    //get result text element
			    MobileElement result_text = (MobileElement) driver.findElementByAccessibilityId("apple_result_text");
				
			    //Validating that result exhibited is '100'
				assertEquals("100", result_text.getText());

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

				//get first_input element
				MobileElement first_input = (MobileElement) driver.findElementByAccessibilityId("apple_first_input");
				
				//type a value on first_input
				first_input.sendKeys("100");
				
				//get second_input element
			    MobileElement second_input = (MobileElement) driver.findElementByAccessibilityId("apple_second_input");
			    
			    //type a value on second_input
			    second_input.sendKeys("4");
			    
			    //get multiply-button element
			    MobileElement divide = (MobileElement) driver.findElementByAccessibilityId("apple-divide-button");
			    
			    //perform a click on divide_button element
			    divide.click();
			    
			    //get result text element
			    MobileElement result_text = (MobileElement) driver.findElementByAccessibilityId("apple_result_text");
				
			    //Validating that result exhibited is '25'
				assertEquals("25", result_text.getText());

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
