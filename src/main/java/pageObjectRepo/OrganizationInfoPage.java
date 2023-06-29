package pageObjectRepo;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//*[@class='dvHeaderText']") private WebElement createdOrgnInfo;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatedOrgnInfo() {
		return createdOrgnInfo;
	}

	public String getCreatedOrgName() {
		String createdOrgName = createdOrgnInfo.getText();
		return createdOrgName;
	}
}
