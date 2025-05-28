package Pratice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class createContactWithOrg {

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

		// step3 - navigate to contact
		driver.findElement(By.linkText("Contacts")).click();

		// step4 - click creat contact
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step5 - enter data in mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Ansarali");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		//Select the Organization
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Set<String> allIds = driver.getWindowHandles();
		allIds.remove(parentId);
		for(String id:allIds) {
			driver.switchTo().window(id);
			driver.findElement(By.linkText("tcs")).click();
			
		}
		driver.switchTo().window(parentId);
		// step6 - save and verify
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String Lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (Lastname.contains("Ansarali")) {
			System.out.println(Lastname + "--pass");

		} else {
			System.out.println(Lastname + "--fail");
		}

		// step7 - logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// step8 - close browser
		driver.quit();

	}

}
