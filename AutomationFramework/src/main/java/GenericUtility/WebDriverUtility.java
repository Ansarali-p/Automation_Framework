package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method used to maximize the window
	 * 
	 * @param driver
	 */
	public void ToMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method used to minimize the window
	 * 
	 * @param driver
	 */
	public void ToMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method used to implecitWait Command
	 * 
	 * @param driver
	 */
	public void ImplecitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method used to Explicitwait command (elementtobeclickable)
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClicablr(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This Method is used toHandleDropDown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropDown(WebElement element, int Index) {
		Select select = new Select(element);
		select.selectByIndex(Index);
	}

	/**
	 * This Method is used toHandleDropDown using Value
	 * 
	 * @param element
	 * @param Value
	 */
	public void toHandleDropDown(WebElement element, String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}

	/**
	 * This Method is used toHandleDropDown using Text
	 * 
	 * @param Text
	 * @param element
	 */
	public void toHandleDropDown(String Text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(Text);
	}

	/**
	 * This method is used to Perform Double Click
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This method is used to Perform Right Click
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to Perform Mouse Hover
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is used to Perform Drag And Drop
	 * 
	 * @param driver
	 * @param src
	 * @param targat
	 */
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement targat) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, targat).perform();
	}

	/**
	 * This method is used to Handle frame using Index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to Handle frame using id_name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * This method is used to Handle frame using WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to driver control back from the frame
	 * 
	 * @param driver
	 */
	public void toSwitchbackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/*
	 * This method is used to handle popup by Accept
	 */
	public void ToHandleAlertpopUpByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to handle popup by Dismiss
	 * 
	 * @param driver
	 */
	public void ToHandleAlertpopUpByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 *  This method is used to handle popup And capture message 
	 * @param driver
	 * @return
	 */
	public String ToHandleAlertpopUpAndCaptureMwssage(WebDriver driver) {
		Alert popup = driver.switchTo().alert();
		String message = popup.getText();
		popup.accept();
		return message;
	}
	/**
	 * This method is use to Take screen shot of web page
	 * @param driver
	 * @param ScreenShotName
	 * @throws IOException
	 */
	public String toTakeScreenShot(WebDriver driver,String ScreenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/"+ ScreenShotName + ".png");
		FileHandler.copy(temp, src);
		String ScreenShotPath = src.getAbsolutePath();
		return ScreenShotPath;
	}
	/**
	 * This method is used to switch the driver control to another window
	 * @param driver
	 * @param partialTittle
	 */
	public void toSwitchWindow(WebDriver driver,String partialTittle) {
		Set<String> allids = driver.getWindowHandles();
		for (String id : allids) {
			String tittle = driver.switchTo().window(id).getTitle();
			if (tittle.contains(partialTittle)) {
				break;
			}
		}
		
	}

}
