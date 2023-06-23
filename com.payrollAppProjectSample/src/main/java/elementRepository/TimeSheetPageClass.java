package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.FileUploadRobot;
import utilities.GeneralUtilities;

public class TimeSheetPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWait ewait = new ExplicitWait();
	FileUploadRobot f = new FileUploadRobot();
	
	public TimeSheetPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Create Timesheet']")
	WebElement createTimesheet;
	
	@FindBy(xpath = "//input[@class='file-caption-name']")
	WebElement selectImageField;
	
	@FindBy(xpath = "//input[@id='file-logo']")
	WebElement browseBtn;
	
	public void fileUpload() throws AWTException, InterruptedException {
		gl.clickElement(createTimesheet);
		f.fileUploadMethod();
	}
	public void clickBrowse() {
		gl.clickElement(browseBtn);
	}
	

}
