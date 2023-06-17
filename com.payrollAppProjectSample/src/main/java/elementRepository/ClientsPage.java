package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class ClientsPage {
	
	WebDriver driver;
	
	GeneralUtilities gl = new GeneralUtilities();
	
	
	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "clientsearch-client_name")
	WebElement clientNameSearchBox;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td[2]")
	WebElement appu;
	
	public void enterClientName(String value) {
		gl.typeText(clientNameSearchBox, value);
	}
	
	public void clickOnSearchBtn() {
		gl.clickElement(searchBtn);
	}
	
	public boolean isClientNameAppuDisplayed() {
		return gl.isDisplayedMethod(appu);
	}
	
		
	public String readClientName(int r, int c) throws IOException
	{
		return ExcelReadClass.readStringData(r,c);
	}

}
