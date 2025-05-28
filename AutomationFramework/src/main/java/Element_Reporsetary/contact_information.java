package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contact_information {
	public contact_information(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement contact_InformationElement;
	@FindBy (linkText = "Google")
	private WebElement organizationNamElement;

	public WebElement getOrganizationNamElement() {
		return organizationNamElement;
	}

	public WebElement getContact_InformationElement() {
		return contact_InformationElement;
	}
	

}
