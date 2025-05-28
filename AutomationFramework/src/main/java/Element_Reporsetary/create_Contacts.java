package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_Contacts {

	public create_Contacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLinkElement;
	
	public WebElement getCreateContactLinkElement() {
		return createContactLinkElement;
	}
}
