package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class HomePage {
	//Initialization
	@FindBy(xpath = "//*[text()='Organizations']/parent::td[@class='tabUnSelected']")
	private WebElement orgLink;
	
	@FindBy(xpath = "//*[text()='Contacts']/parent::td[@class='tabUnSelected']")
	private WebElement contactsLink;
	
	@FindBy(xpath="//*[text()='Opportunities']/parent::td[@class='tabUnSelected']")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//*[text()='Products']/parent::td[@class='tabUnSelected']")
	private WebElement productsLink;
	
	@FindBy(xpath = "//*[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//*[text()='Sign Out']")private WebElement signOutBtn;
	
	
	//declaration
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
    public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	
	//business logic
	public void clickOnOrganization(WebDriver driver)
	{
		orgLink.click();
	}
	
	public void clickOnContac() {
		contactsLink.click();
	}

	public void signOut(WebDriver driver) {
		SeleniumUtilities.mousehover(driver, adminImg, "Administrator");
		signOutBtn.click();	
	}
	
	

}
