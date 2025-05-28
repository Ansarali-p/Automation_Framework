package Pratice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Element_Reporsetary.contact_information;
import Element_Reporsetary.create_Contacts;
import Element_Reporsetary.create_New_Contact;
import Element_Reporsetary.home_Page;
import Element_Reporsetary.login_page;
import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;

public class Demo_Script_With_DDL_and_POM {

	public static void main(String[] args) throws IOException {
		// To read data from property file
		PropertyFileUtility putil = new PropertyFileUtility();
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		// to read data from excel file
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		
		// For method
		WebDriverUtility wutil = new WebDriverUtility();
		
		// Test Scripts
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();	
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		wutil.ToMaximize(driver);
		wutil.ImplecitWait(driver);
		driver.get(URL);
		
		// Step 2 login
		login_page lp = new login_page(driver);
		lp.getUsernameTextfieldElement().sendKeys(USERNAME);
		lp.getPasswordTextfieldElement().sendKeys(PASSWORD);
		lp.getLoginbuttonElement().click();
		
		//step 3 Navigate to contact link
		home_Page hP = new home_Page(driver);
		hP.getContactsLink().click();
		
		// step 4 click on create contact + icon
		create_Contacts cc = new create_Contacts(driver);
		cc.getCreateContactLinkElement().click();
		
		// step 5 create contact with mandatory field
		create_New_Contact cnc = new create_New_Contact(driver);
		cnc.getLastNamElement().sendKeys(LASTNAME);
		
		// step 6 save and verify
		cnc.getSaveButtonElement().click();
		contact_information ci = new contact_information(driver);
		String lastname = ci.getContact_InformationElement().getText();
		if (lastname.contains(LASTNAME)) {
			System.out.println(lastname+"Psaa");
			
		}
		else {
			System.out.println(lastname+"Fail");
		}
		
		// step 7 logout
		wutil.toMouseHover(driver, hP.getLogoutElement());
		hP.getSignoutlinkElement().click();
		
		// close
		driver.close();

	}

}
