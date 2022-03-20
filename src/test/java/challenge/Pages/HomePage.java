package challenge.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	public HomePage(WebDriver browser) {
		super(browser);
		
		
		// Waiting to home page has completely loaded
		WebDriverWait wait_HomePageLoad = new WebDriverWait(browser, 10);
		wait_HomePageLoad
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_top_menu")));
	}
	
	//Just a click on 'sign in' button
	public AuthenticationPage clickBtnSign() {
		
		// Click on sign in button
		browser.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"))
				.click();
		
		return new AuthenticationPage(browser);
	}
	
	
	
}
