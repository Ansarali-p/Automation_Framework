package Pratice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Element_Reporsetary.create_New_Organization;

public class create_random_name_org {

	public static void main(String[] args) {
		// step1 - lanuch browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
						
				// step2 - login with valid data
				driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
				
				// step3 - navigate to Organizations
				driver.findElement(By.linkText("Organizations")).click();
				
				// step4 - click creat Organizations
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				// step5 - enter data in mandatory fields
				Random r = new Random();
				int Random_value = r.nextInt(1000);
				driver.findElement(By.name("accountname")).sendKeys("Google"+Random_value);
				
				// step6 - save and verify
				create_New_Organization cno = new create_New_Organization(driver);
				cno.getSave_ButtonElement().click();
				//driver.findElement(By.name("button")).click();
				String Org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (Org_name.contains("Google"+Random_value)) {
					System.out.println(Org_name+"--pass");
								
					}
				else {
						System.out.println(Org_name+"--fail");
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
