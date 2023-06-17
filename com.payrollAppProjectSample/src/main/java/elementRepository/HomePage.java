package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class HomePage {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWait ewait = new ExplicitWait();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@src='/payrollapp/images/logo.png']")
	WebElement logoCareDirect;
	
	@FindBy(xpath = "//*[text()='Carol Thomas']")
	WebElement carolThomas;
	
	@FindBy(xpath = "//a[text()='Company']")
	WebElement companyTab;
	
	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientTab;
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	WebElement dashboardTab;
	
	
	
	public boolean isLogoDisplayed() {
		ewait.explicitWaitPresenceOfElementsLocated(driver, "//img[@src='/payrollapp/images/logo.png']");
		return gl.isDisplayedMethod(logoCareDirect);
		
	}
	
	public void clickOnClient() {
		gl.clickElement(clientTab);
	}
	

}
