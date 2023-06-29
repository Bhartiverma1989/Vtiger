package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtilities {
	
	/**
	 * @param driver
	 * Method to use maximize browser
	 */
	public static void maximizeBrowser(WebDriver  driver) {
		try{
			driver.manage().window().maximize();
			System.out.println("Browser is maximize");
		}catch(Exception e){
			System.out.println("Browser is not maximize");
		}
	}
	
		/**
		 * @param driver
		 * Method to minimize browser	
		 */
	public static void minimizeBrowser(WebDriver  driver){
		try{
			//driver.manage().window().minimize();
			System.out.println("Browser is minimize");
		}catch(Exception e){
			System.out.println("Browser is not minimize");
		}
	}
	
	/**
	 * @param driver
	 * This method is used to delete cookies
	 */
	public static void deleteCookies(WebDriver driver){
		try {
		driver.manage().deleteAllCookies();
		System.out.println("cookies are deleted");
			
		}catch(Exception e) {
			System.out.println("cookies are not deleted");
			
		}
	}
		
       /**
        * @param driver
        * This method is used for Implicit wait
        */
		public static void waitToLoadPage(WebDriver driver) {
			//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
				}
		
		/**
		 * wait for specific element to be visible (Explicit wait)
		 * @param driver 
		 * @param element 
		 */
		public static void waitForSpecificElementToBeVisibile(WebDriver driver, WebElement element) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		
		/**
		 * wait for specific text to be present
		 * @param driver 
		 * @param element 
		 * @param text 
		 */
		public static void waitForSpecificTextToBePresent(WebDriver driver, WebElement element, String text)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		}
		
		/**
		 * wait for specific element to disappear by locator
		 * @param driver 
		 * @param locator 
		 * 
		 */
		
		public static void waitUntillSpecificElementInvisible(WebDriver driver, By locator)
		{
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(80))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);
			
			fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			
			}
		/**
		 * method is used to handle dropdown by index
		 * @param driver 
		 * @param element 
		 * @param index 
		 */
		public static void handleDropdownByIndex( WebElement element, int index){
			try {
				Select select = new Select(element);
				select.selectByIndex(index);
				System.out.println("Element is select at "+index+" index from dropdown");		
			}catch(Exception e) {
				System.out.println("Element is not selected from dropdown");
			}
		}
		/**Method is used to handle dropdown by value
		 * @param element 
		 * @param value 
		 * 
		 */
		public static void HandleDropdownByValue(WebElement element, String value){
			try {
			Select select = new Select(element);
			select.selectByValue(value);
			System.out.println(value+" is selected from dropdown");	
			}catch(Exception e) {
				System.out.println(value+" is not selected from dropdown");
			}
		}
		
		/**
		 * method to handle dropdown by visible text
		 */
		public static void HandleDropdownByVisibleText(WebElement element, String text){
			try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			System.out.println(text+" is selected from dropdown");	
			}catch(Exception e) {
				System.out.println(text+" is not selected from dropdown");
			}
		}
		/**
		 * Method to perform clcik on element
		 * @param fieldName 
		 * @param element. 
		 * 
		 */
		public static void click(WebElement element, String fieldName) {
			try {
				element.click();
				System.out.println(fieldName+ "is clicked sucessfully");
				
			}catch(Exception e) {
				System.out.println(element.toString() +" elemet is not clicked "+e.getMessage());
			}
		}
		
		/**
		 * to pause the execution untill the expected element click able
		 * @param driver 
		 * @param element 
		 * @param fieldName 
		 */
		public static void waitAndClick(WebDriver driver, WebElement element, String fieldName) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				System.out.println(fieldName+"element is clicked sucessfully");
				
			}catch(Exception e) {
				System.out.println("elemet is not clciked at this point exception ");
				System.out.println(element.toString()+" element is not clicked "+e.getMessage());
			}
		}
		
		/**
		 * Method to perform  click after mouse hover on target element using action class
		 * @param driver 
		 * @param element 
		 */
		
		public static void actionClick(WebDriver driver, WebElement element) {
			try {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().build().perform();
				System.out.println(element.toString()+ " elemet is clicked sucessfully");
			}catch(Exception e) {
				System.out.println(element.toString()+ " elemet is not clicked "+e.getMessage());
			}
		}
		
		/**
		 * Method to perform right click on page 
		 * @param driver 
		 * 
		 */
		public static void rightClickActionOnPage(WebDriver driver, String fieldName) {
			try {
				Actions action = new Actions(driver);
				action.contextClick().build().perform();
				System.out.println( "On"+fieldName +" right clicked action is perform sucessfully");
				
			}catch(Exception e) {
				System.out.println( "On"+fieldName +" right clicked action is not performed "+e.getMessage());
				}
		}
		
		/**
		 * Method to perform right click on web element 
		 * @param driver 
		 * @param element 
		 * 
		 */
		public static void rightClickActionOnElement(WebDriver driver, String fieldName, WebElement element) {
			try {
				Actions action = new Actions(driver);
				action.contextClick(element).build().perform();
				System.out.println( element.toString()+" right clicked action is performed sucessfully");
				
			}catch(Exception e) {
				System.out.println( element.toString() +" right clicked action is not performed "+e.getMessage());
				}
		}
		
		/**
		 * Method to perform double click action
		 * @param driver 
		 * @param element 
		 */
		public static void doubleClickActionOnElement(WebDriver driver, WebElement element) {
			try {
				Actions action = new Actions(driver);
				action.doubleClick(element).build().perform();
				System.out.println(element.toString()+" double click is performed");
				
			}catch(Exception e) {
				System.out.println(element.toString()+" double click is not performed"+ e.getMessage());
				
			}
		}
		
		/**
		 * Method to perform double click on web page (any where on web page
		 * @param fieldName 
		 */
		public static void doubleClickOnwebpage(WebDriver driver, String fieldName){
			try {
				Actions action = new Actions(driver);
			action.doubleClick().perform();
			System.out.println("On"+fieldName +" right clicked action is performed ");
			}catch(Exception e) {
				System.out.println("On"+fieldName +" right clicked action is not performed "+e.getMessage());
			}
		}
		/**
		 * method to perform drag and drop element from source to target
		 * @param driver 
		 * @param srcElement 
		 * @param targetElement 
		 */
		
		public static void dragAnddrop(WebDriver driver, WebElement srcElement, WebElement targetElement) {
			try {
			Actions action = new Actions(driver);
			action.dragAndDrop(srcElement, targetElement).perform();
			System.out.println(srcElement+" element drag and drop on "+targetElement +"element");
		}catch(Exception e) {
			System.out.println(srcElement+" element is unable to drag and drop on "+targetElement +"element"+e.getMessage());
		}
		}
		/**
		 * method to perform mouse hover action
		 * @param driver 
		 * @param element 
		 * @param fieldname 
		 */
		public static void mousehover(WebDriver driver, WebElement element, String fieldname) {
			try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			System.out.println("mouse hover on the "+fieldname);
		}catch(Exception e) {
			System.out.println("unable to mouse hover on the "+fieldname + e.getMessage());
		}
		}
		
		/**
		 * method to handle I - Frame By index
		 * @param driver 
		 * @param index 
		 */
		
		public static void switchToFrameByIndex(WebDriver driver, int index) {
			try {
			driver.switchTo().frame(index);
			System.out.println("switch to I-Frame at index "+index);
		}catch(Exception e) {
			System.out.println("not able to switch to I-Frame at index "+index +e.getMessage());
		}
		}
		
		/**
		 * method to switch the I-frame by name or Id
		 * @param nameOrID 
		 */
		
		public static void switchToFrameByNameOrID(WebDriver driver, String nameOrID) {
			try {
			driver.switchTo().frame(nameOrID);
			System.out.println("switch to I-Frame having name or ID "+nameOrID);
		}catch(Exception e) {
			System.out.println("not able to switch to I-Frame at index "+nameOrID +e.getMessage());
		}
		}
		
		/**
		 * method to switch the I-frame by web element
		 * @param driver 
		 * @param frameElement 
		 * @param fieldName 
		 */
		
		public static void switchToFrameByElement(WebDriver driver, WebElement frameElement, String fieldName) {
			try {
				driver.switchTo().frame(frameElement);
				System.out.println("switch to I-Frame of element "+fieldName);
		}catch(Exception e) {
			System.out.println("not able to switch to I-Frame at index "+frameElement +e.getMessage());
		}
		}
		
		/**
		 * method to used to switch parent frame
		 * @param driver 
		 */
		
		public static void switchToParentFrame(WebDriver driver) {
			driver.switchTo().parentFrame();
			System.out.println("Focus is switch to parent Frame");
		}
		
		/**
		 * method used to switch most parent Frame (if we have nested frame and want to switch to most parent frame)
		 */
		
		public static void switchToMostParentFrame(WebDriver driver) {
			driver.switchTo().defaultContent();
			System.out.println("Focus is switch to most parent Frame");
		}
		
		/**
		 * method to perform/handle popup (accept alert)
		 */
		
		public static void acceptalert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		/**
		 * method to reject alert
		 */
		
		public static void dismisstAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		/**
		 * method to send text in alert
		 * @param text 
		 */
		public static void setTextInAlert(WebDriver driver, String text) {
			driver.switchTo().alert().sendKeys(text);
			System.out.println(text +" Alert message is send in alert text box");
		}
		
		/**
		 * method used to get alert message
		 * @return 
		 */
		public static String getAlertText(WebDriver driver)
		{
			String alertText=driver.switchTo().alert().getText();
			return alertText;
		}
		/**
		 * method used to switch window
		 * @param driver
		 * @param partialTitle
		 */
		public static void switchTowindow(WebDriver driver, String partialTitle) {
			//step 1 : capture all window
			Set<String> winIDS = driver.getWindowHandles();
			//step 2 :navigate to each window
			for(String winID:winIDS) {
				String actTitle = driver.switchTo().window(winID).getTitle();
				if(actTitle.contains(partialTitle)) {
					break;
				}
				
			}
			
		}
		
		/**
		 * method to capture screen shot
		 * @param screenShotname 
		 * @return 
		 * @throws IOException 
		 */
		
		public static String takeScreenShot(WebDriver driver, String screenShotname) throws IOException {
			//step1 : type cast driver object, i.e assigning the object of webdriver to takescreenShot
			TakesScreenshot ts = (TakesScreenshot )driver;
			//step 2 : get Screenshot and store in source file
			File src=ts.getScreenshotAs(OutputType .FILE);
			//step3 : move the stored screen shot to your destination folder
			File dest = new File(".\\Screenshot"+screenShotname+".png");
			
			Files.copy(src, dest);
			return dest.getAbsolutePath(); // it is provide the path of ss , usefull when we send the report 
			
		}
		
		/**
		 * method used to scroll the page
		 */
		
		public static void scrollPageByjs(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor )driver;
			js.executeScript("window.ScrollBy", 0,500);
			
		}
		/**
		 * method to perform java script click
		 * @param element 
		 */
		
		public static void clckjs(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor )driver;
			js.executeScript("arguments[0].click();", element);
			System.out.println(element.toString()+ "element"+element.getText()+" is clicked sucessfully");
			
		}
		/**
		 * method to perform java script set text
		 * @param sentText 
		 */
		public static void setTextjs(WebDriver driver, WebElement element, String sentText) {
			element.sendKeys(null);
			JavascriptExecutor js = (JavascriptExecutor )driver;
			js.executeScript("arguments[0].value='text' ;", element);
			
		}
		
	}



