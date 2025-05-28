package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Element_Reporsetary.home_Page;
import Element_Reporsetary.login_page;

public class BassClass {
	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smoke", "regression" })
	public void beforeSuiteConfig() {
		System.out.println("---DataBase Connection Estabhlished---");
	}

	// @Parameters("browser")
	// @BeforeTest
	@org.testng.annotations.BeforeClass(groups = { "smoke", "regression" })
	public void beforeClassConfing(/* String BROWSER */) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver=driver;//Listener
		System.out.println("Browser got launched ");
		wutil.ToMaximize(driver);
		System.out.println("Browser got Maximize");
		wutil.ImplecitWait(driver);
		driver.get(URL);
		

	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void beforeMethodConfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		login_page lP = new login_page(driver);
		lP.getUsernameTextfieldElement().sendKeys(USERNAME);
		lP.getPasswordTextfieldElement().sendKeys(PASSWORD);
		lP.getLoginbuttonElement().click();
		System.out.println("Sucessfully logged in Vtiger");
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void afterMethodConfig() {
		home_Page hp = new home_Page(driver);
		wutil.toMouseHover(driver, hp.getLogoutElement());
		hp.getSignoutlinkElement().click();
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void afterClassConfig() {
		System.out.println("Browser got close");
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void afterSuiteConfig() {
		System.out.println("---DataBase Connection Disconnected---");
	}

}
