package challenge.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver browser) {
		super(browser);

		// Waiting to my account page until it's loaded
		WebDriverWait wait_MyAccountPage = new WebDriverWait(browser, 10);
		wait_MyAccountPage.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-account")));
	}
	
	//returns the info-account class's content
	public String ValidatingMy_account() {
		return browser.findElement(By.className("info-account")).getAttribute("innerText");
	}
	
	

}
