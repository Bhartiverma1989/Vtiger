package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.PropertyFileUtility1;
import genericUtilities.SeleniumUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrgTest {
	public static WebDriver driver;
	@Test
	public void launchBrowser()throws Throwable {
		PropertyFileUtility1 proertyFileUtility = new PropertyFileUtility1();
		
	String Browser= proertyFileUtility.readDataFromPropertyFile("browser");
	
	//WebDriver driver=null;
	if(Browser.equalsIgnoreCase("chrome")) {
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		SeleniumUtilities.maximizeBrowser(driver);
		System.out.println("chrome browser is launch");
		driver.get(proertyFileUtility.readDataFromPropertyFile("url"));
		
		System.out.println("User navigate to application");
	}
	else if(Browser.equalsIgnoreCase("firefox")) {
		//WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		SeleniumUtilities.maximizeBrowser(driver);
		System.out.println("FireFox browser is launch");
		driver.get(proertyFileUtility.readDataFromPropertyFile("url"));
		System.out.println("User navigate to application");
		
	}else {
		System.out.println("Enter proper Browse name");
		
	}
		
	}

}
