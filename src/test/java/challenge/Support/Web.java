package challenge.Support;

//import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	// Global variables
	public static WebDriver browser;

	// BrowseStack Variables
	// public static final String USERNAME = "?";
	// public static final String AUTOMATE_KEY = "?";
	// public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY +
	// "@hub-cloud.browserstack.com/wd/hub";

	// Start function and instance of Webbrowser browser
	public static WebDriver Start() {

		// Desired Capabilities for Chrome*************************************

		// Setting the Chrome Options
		/*DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("project", "Challenge");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browserstack.networkLogs", "true");*/

		// Instancing the Chrome browser
		try {
			//browser = new RemoteWebbrowser(new URL(URL), caps);
			
			
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
			browser =new ChromeDriver();
			browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			
		} catch (Exception e) {
			System.out.println("Erro na instancia browser Chrome: " + e.getMessage());
		}

		// return Webbrowser browser's instance
		return browser;
	}

}
