package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_New_Contact {
	public create_New_Contact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "lastname")
	private WebElement lastNamElement;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement saveButtonElement;
	
	@FindBy (xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookupimagElement;
	
	public WebElement getOrgLookupimagElement() {
		return orgLookupimagElement;
	}

	public WebElement getLastNamElement() {
		return lastNamElement;
	}

	public WebElement getSaveButtonElement() {
		return saveButtonElement;
	}

}
