package executeClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class ExecuteHomePage extends BaseClass{
	LoginPage lp;
	HomePage hp;
	
  @Test(groups = {"group1"},dataProvider = "DataProvider",dataProviderClass = DataProviderLogin.class)
  public void verifyTheLogoIsDisplayedOrNot(String name, String pass) {
	  lp = new LoginPage(driver);
	  lp.login(name,pass);
	  hp = new HomePage(driver);
	  Assert.assertTrue(hp.isLogoDisplayed());
  }
  

}
