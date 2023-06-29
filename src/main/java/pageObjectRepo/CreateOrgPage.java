package pageObjectRepo;

import java.util.Objects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	@FindBy(xpath="//*[@name='accountname']") private WebElement orgName;
	
	@FindBy(xpath = "//*[@name='website']") private WebElement website;
	
	@FindBy(xpath = "//*[@name='tickersymbol']")private WebElement ticketSymbol;
	
	@FindBy(xpath="//*[@name='employees']") private WebElement employee;
	
	@FindBy(xpath="//*[@name='email2']") private WebElement otherEmail;
	
	@FindBy(xpath = "//*[@name='industry']") private WebElement selectIndustry;
	
	@FindBy(xpath = "//*[@name='accounttype']")private WebElement accountType;
	
	@FindBy(xpath = "//*[@type='checkbox' and @name='emailoptout']") private WebElement emailOptOut;
	
	@FindBy(xpath="//*[@value='T' and @name='assigntype']")private WebElement assignType;
	
	@FindBy(xpath="//*[@class='crmbutton small save']")private WebElement saveBtn;
	
	@FindBy(xpath="//*[@class='crmbutton small cancel']")private WebElement cancelBtn;
	
	//Initialization
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business logic
	
	public void enterOrgName(String orgname) {
		orgName.sendKeys(orgname);
	}

	public void enterWebsite(String orgWebsite) {
		website.sendKeys(orgWebsite);
	}
	
	public void clickOnsave() {
		saveBtn.click();
	}
	
	
	
	
	
	
	
	

}
