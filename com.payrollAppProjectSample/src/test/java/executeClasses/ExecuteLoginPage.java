package executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import retryAnalyzer.RetryAnalyzer;

public class ExecuteLoginPage extends BaseClass{
	
	LoginPage lp;
	
  @Test(dataProvider = "DataProvider",dataProviderClass = DataProviderLogin.class)
  public void verifySuccessfulLogin(String name, String pass) {
	  lp = new LoginPage(driver);
	  lp.login(name,pass);
	  boolean act = lp.isCarolThomasDisplayed();
	  Assert.assertTrue(act);
	  
  }
  
  @Test(dataProvider = "DataProvider1",dataProviderClass = DataProviderLogin.class, retryAnalyzer = RetryAnalyzer.class)
  public void verifyUnsuccessfulLogin(String name, String pass) {
	  lp = new LoginPage(driver);
	  lp.login(name,pass);
	  boolean act = lp.isIncorectMsgDisplayed();
	  Assert.assertTrue(act);
	  
  }
  
  @Test(groups = {"group1"})
  public void verifyTheLoginHeadingIsDisplayedOrNot() {
	  lp = new LoginPage(driver);
	  boolean exp = true;
	  boolean act = lp.isHeadingLoginDisplayed();
	  Assert.assertEquals(act, exp);
  }
  
 
}
