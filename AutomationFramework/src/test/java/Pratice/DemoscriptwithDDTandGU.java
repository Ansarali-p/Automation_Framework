package Pratice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;

public class DemoscriptwithDDTandGU {

	public static void main(String[] args) throws IOException {
		//to read data from property file
		PropertyFileUtility pfu = new PropertyFileUtility();
		String URL = pfu.toReadDataFromPropertyFile("url");
		String BROWSER = pfu.toReadDataFromPropertyFile("browser");
		String USERNAME = pfu.toReadDataFromPropertyFile("username");
		String PASSWORD = pfu.toReadDataFromPropertyFile("password");
		
		// TO read data from excel file
		ExcelFileUtility efu = new ExcelFileUtility();
		String LASTNAME = efu.toReadDataFromExcelFile("Contacts", 1, 2);
		
		//TEST script
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		// step2 - login with valid data
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				// step3 - navigate to contact
				driver.findElement(By.linkText("Contacts")).click();
				
				// step4 - click creat contact
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				// step5 - enter data in mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				// step6 - save and verify
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				 String Lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (Lastname.contains(LASTNAME)) {
					System.out.println(Lastname+"--pass");
					
				}
				else {
					System.out.println(Lastname+"--fail");
				}
				
				//step7 - logout
				WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(logout).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
				//step8 - close browser
				driver.quit();
		

	}

}
