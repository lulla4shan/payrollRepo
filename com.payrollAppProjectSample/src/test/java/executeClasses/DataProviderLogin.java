package executeClasses;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderLogin {
  

  @DataProvider(name = "DataProvider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "carol", "1q2w3e4r" }
      
    };
  }
  
  @DataProvider(name = "DataProvider1")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "admin123", "password" },
      new Object[] { "admin", "pass" },
      new Object[] {"adm155","afrt"}
    };
  }
}
