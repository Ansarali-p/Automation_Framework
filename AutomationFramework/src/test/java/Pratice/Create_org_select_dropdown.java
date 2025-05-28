package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.build.AndroidDescriptor;

public class Create_org_select_dropdown {

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
				driver.findElement(By.name("accountname")).sendKeys("Dell");
				
				// select dropdown "Chemicals"
				WebElement dropdown = driver.findElement(By.name("industry"));
				Select select =new Select(dropdown);
				select.selectByValue("Chemicals");
				
				// save and verify
				driver.findElement(By.name("button")).click();
				String Org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				String drop = driver.findElement(By.xpath("//font[text()='Chemicals']")).getText();
				if (Org_name.contains("Dell")& drop.contains("Chemicals")) {
					System.out.println(Org_name+drop+"--pass");
								
					}
				else {
						System.out.println(Org_name+drop+"--fail");
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
