package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_New_Organization {
	public create_New_Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "accountname")
	private WebElement organization_NamElement;
	
	@FindBy (name = "industry")
	private WebElement industry_Dropdown;
	
	@FindBy (name = "accounttype")
	private WebElement type_dropdownElement;
	
	@FindBy (name = "button")
	private WebElement save_ButtonElement;
	
	public WebElement getOrganization_NamElement() {
		return organization_NamElement;
	}

	public WebElement getIndustry_Dropdown() {
		return industry_Dropdown;
	}

	public WebElement getType_dropdownElement() {
		return type_dropdownElement;
	}

	public WebElement getSave_ButtonElement() {
		return save_ButtonElement;
	}


}
