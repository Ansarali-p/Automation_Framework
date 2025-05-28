package Element_Reporsetary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class home_Page {
	//constructor
	 public home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	 @FindBy (linkText = "Contacts")
	 private WebElement contactsLink;
	 
	 @FindBy (linkText = "Organizations")
	 private WebElement organizationlinkElement;
	 
	 @FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	 private WebElement logoutElement;
	 
	 @FindBy (linkText = "Sign Out")
	 private WebElement signoutlinkElement;

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationlinkElement() {
		return organizationlinkElement;
	}

	public WebElement getLogoutElement() {
		return logoutElement;
	}

	public WebElement getSignoutlinkElement() {
		return signoutlinkElement;
	}
		
	

}
