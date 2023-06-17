package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "loginform-username") 
	WebElement username;
	
	@FindBy(id = "loginform-password") 
	WebElement password;
	
	@FindBy(id = "loginform-rememberme") 
	WebElement rememberMeCheckBox;
	
	@FindBy(name = "login-button") 
	WebElement loginButton;
	
	@FindBy(xpath = "//h1[text()='Login']") 
	WebElement LoginText;
	
	@FindBy(xpath = "//*[text()='Carol Thomas']")
	WebElement carolThomas;
	
	@FindBy(xpath = "//p[starts-with(text(),'Incorrect username')]")
	WebElement incorrectUsernameAndPassword;
	
	public boolean isHeadingLoginDisplayed() {
		return gl.isDisplayedMethod(LoginText);
	}
	
	public void login(String uname, String passwd) {
		gl.typeText(username, uname);
		gl.typeText(password, passwd);
		gl.clickElement(loginButton);
	}
	
	
	public boolean isCarolThomasDisplayed() {
		return gl.isDisplayedMethod(carolThomas);
		
	}
	public boolean isIncorectMsgDisplayed() {
		return gl.isDisplayedMethod(incorrectUsernameAndPassword);
		
	}
	

}
