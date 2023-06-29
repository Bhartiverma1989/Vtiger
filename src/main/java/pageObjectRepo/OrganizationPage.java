package pageObjectRepo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createOrg;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Search.gif']") private WebElement searchOrg;
	
	//Initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getSearchOrg() {
		return searchOrg;
	}

	//business logic
	
	public void clickOnCreateOrganization() {
		createOrg.click();
	}
	
	

}
