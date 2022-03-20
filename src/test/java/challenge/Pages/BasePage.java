package challenge.Pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver browser;

	public BasePage(WebDriver browser) {
		this.browser = browser;
	}
	
	
	
	
	// Randon Numbers Generator
	public static String RandomValues() {
		Random r = new Random();
		String number = "";

		// imprime sequencia de 8 numeros inteiros aleatorios entre 1 e 9
		for (int i = 0; i < 8; i++) {
			int randomNumber = r.nextInt(9);
			if (randomNumber != 0) {
				number = number + randomNumber;
			} else {
				number = number + 1;
			}
		}
		return number;
	}

}
