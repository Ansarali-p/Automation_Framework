package OrganizationTest;

import java.io.IOException;

import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Element_Reporsetary.Organization_Information;
import Element_Reporsetary.create_New_Organization;
import Element_Reporsetary.create_Organization;
import Element_Reporsetary.home_Page;
import GenericUtility.BassClass;
import GenericUtility.ExcelFileUtility;
@Listeners(GenericUtility.ListenersImplementation.class)

public class ToCreateOrganizationTest extends BassClass {
	@Test(groups = "regression")
	public void toCreateOrganization() throws EncryptedDocumentException, IOException {
		// navigate to org link
		home_Page hp = new home_Page(driver);
		hp.getOrganizationlinkElement().click();
		// click + icon
		create_Organization co = new create_Organization(driver);
		co.getCreate_Organization().click();
		// fill the org name
		ExcelFileUtility eutil = new ExcelFileUtility();
		String ORGANIZATIONNAME = eutil.toReadDataFromExcelFile("Organisation", 1, 2);
		Random r = new Random();
		int Random_value = r.nextInt(1000);
		create_New_Organization cno = new create_New_Organization(driver);
		cno.getOrganization_NamElement().sendKeys(ORGANIZATIONNAME+Random_value);
		//save and verify
		cno.getSave_ButtonElement().click();
		Organization_Information oi = new Organization_Information(driver);
		String orgname = oi.getOrg_InformationElement().getText();
		Assert.assertTrue(orgname.contains(ORGANIZATIONNAME));
		
		
	}

}
