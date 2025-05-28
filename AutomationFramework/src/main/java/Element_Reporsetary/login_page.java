package Element_Reporsetary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
	//Constructor
	public login_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernameTextfieldElement;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextfieldElement;
	
	@FindBy(id = "submitButton")
	private WebElement loginbuttonElement;

	public WebElement getUsernameTextfieldElement() {
		return usernameTextfieldElement;
	}

	public WebElement getPasswordTextfieldElement() {
		return passwordTextfieldElement;
	}

	public WebElement getLoginbuttonElement() {
		return loginbuttonElement;
	}

}
