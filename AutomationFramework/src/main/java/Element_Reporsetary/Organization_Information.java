package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Information {
	public Organization_Information(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getOrg_InformationElement() {
		return org_InformationElement;
	}

	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement org_InformationElement;
	@FindBy (xpath = "//font[text()='Chemicals']")
	private WebElement org_Industry_DropDownElement;
	@FindBy (xpath = "//font[text()='Customer']")
	private WebElement org_Type_DropDownElement;
	public WebElement getOrg_Type_DropDownElement() {
		return org_Type_DropDownElement;
	}

	public WebElement getOrg_Industry_DropDownElement() {
		return org_Industry_DropDownElement;
	}

}
