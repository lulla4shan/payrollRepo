package executeClasses;

import java.awt.AWTException;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.TimeSheetPageClass;

public class ExecuteTimesheetPage extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	TimeSheetPageClass t;
  @Test
  public void f() throws AWTException, InterruptedException {
	  lp= new LoginPage(driver);
	  hp = new HomePage(driver);
	  t = new TimeSheetPageClass(driver);
	  
	  lp.login("carol", "1q2w3e4r");
	  hp.clickOnTimesheet();
	  t.fileUpload();
	  t.clickBrowse();
  }
}
