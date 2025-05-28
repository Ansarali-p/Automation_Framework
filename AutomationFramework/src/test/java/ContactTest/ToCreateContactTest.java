package ContactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Element_Reporsetary.contact_information;
import Element_Reporsetary.create_Contacts;
import Element_Reporsetary.create_New_Contact;
import Element_Reporsetary.home_Page;
import GenericUtility.BassClass;
import GenericUtility.ExcelFileUtility;

@Listeners(GenericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BassClass {
	@Test(groups = "smoke")
	public void tocreateContact_001() throws EncryptedDocumentException, IOException {
		// to click on contacts link
		home_Page hp = new home_Page(driver);
		hp.getContactsLink().click();
		// click on create contact look up image
		create_Contacts cc = new create_Contacts(driver);
		cc.getCreateContactLinkElement().click();
		;
		// to read data from excel file
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
		// to fill mandatory fields
		create_New_Contact cnc = new create_New_Contact(driver);
		cnc.getLastNamElement().sendKeys(LASTNAME);
		// to save and verify
		cnc.getSaveButtonElement().click();
		// Assert.fail();// fail test script
		contact_information ci = new contact_information(driver);
		String lastname = ci.getContact_InformationElement().getText();
		Assert.assertTrue(lastname.contains(LASTNAME));

	}

}
