package executeClasses;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class ExecuteClientsPage extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	ClientsPage cp;
	
  @Test
  public void verifyClientSearch() throws IOException {
	  
	  lp = new LoginPage(driver);
	  hp = new HomePage(driver);
	  cp = new ClientsPage(driver);
	  
	  lp.login("carol", "1q2w3e4r");
	  hp.clickOnClient();
	  cp.enterClientName(cp.readClientName(3,1));
	  cp.clickOnSearchBtn();
	  
	  boolean act = cp.isClientNameAppuDisplayed();
	  Assert.assertTrue(act);
	  
	  
  }
}
