package OrganizationTest;

import java.io.IOException;

import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Element_Reporsetary.Organization_Information;
import Element_Reporsetary.create_New_Organization;
import Element_Reporsetary.create_Organization;
import Element_Reporsetary.home_Page;
import GenericUtility.BassClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.WebDriverUtility;
@Listeners(GenericUtility.ListenersImplementation.class)
public class ToCreateOrganizationWithTwoDropDownTest extends BassClass {
	@Test(groups = "regression")
	public void ToCreateOrgWithTwoDropDown() throws EncryptedDocumentException, IOException {
		// navigate to org link
		home_Page hp = new home_Page(driver);
		hp.getOrganizationlinkElement().click();
		// click + icon
		create_Organization co = new create_Organization(driver);
		co.getCreate_Organization().click();
		// fill the org name and drop down
		ExcelFileUtility eutil = new ExcelFileUtility();
		String ORGANIZATIONNAME = eutil.toReadDataFromExcelFile("Organisation", 1, 2);
		String DROPDOWN = eutil.toReadDataFromExcelFile("Organisation", 4, 3);
		String TYPEDROPDOWN = eutil.toReadDataFromExcelFile("Organisation", 4, 4);
		Random r = new Random();
		int Random_value = r.nextInt(1000);
		create_New_Organization cno = new create_New_Organization(driver);
		cno.getOrganization_NamElement().sendKeys(ORGANIZATIONNAME + Random_value);
		WebElement DropDown = cno.getIndustry_Dropdown();
		WebDriverUtility wdutil = new WebDriverUtility();
		wdutil.toHandleDropDown(DROPDOWN, DropDown);
		WebElement TypeDropDown = cno.getType_dropdownElement();
		wdutil.toHandleDropDown(TYPEDROPDOWN, TypeDropDown);
		// save and verify
		cno.getSave_ButtonElement().click();
		Organization_Information oi = new Organization_Information(driver);
		String orgname = oi.getOrg_InformationElement().getText();
		String industrydropdown = oi.getOrg_Industry_DropDownElement().getText();
		String typedropdown = oi.getOrg_Type_DropDownElement().getText();
		Assert.assertTrue(orgname.contains(ORGANIZATIONNAME+Random_value)&
		industrydropdown.contains(DROPDOWN)& typedropdown.contains(TYPEDROPDOWN));
	}
}
