package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_Organization {
	public create_Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@title='Create Organization...']")
	private WebElement create_Organization;

	public WebElement getCreate_Organization() {
		return create_Organization;
	}

}
