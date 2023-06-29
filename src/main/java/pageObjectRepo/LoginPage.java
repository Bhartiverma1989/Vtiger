package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//*[@name='user_name']")private WebElement usernametxt;
	
	@FindBy(xpath="//*[@name='user_password']")private WebElement pwdtxt;
	
	@FindBy(id = "submitButton")private WebElement loginbtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApp(String username, CharSequence password)
	{
		usernametxt.sendKeys(username);
		pwdtxt.sendKeys(password);
		loginbtn.click();
	}
	

}
