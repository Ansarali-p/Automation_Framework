package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOrganizationPopUp {
	public SelectOrganizationPopUp(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Google")
	private WebElement selectOrganizationinPopUpElement;

	public WebElement getSelectOrganizationinPopUpElement() {
		return selectOrganizationinPopUpElement;
	}

}
