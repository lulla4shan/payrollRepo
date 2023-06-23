package executeClasses;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotClass;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	WebDriver driver;
	ScreenShotClass sh;

	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties");
		property.load(fs);
	}

	@BeforeSuite(alwaysRun = true)
	public void createReport(final ITestContext testContext) {
		extendReport.ExtentManager.createInstance().createTest(testContext.getName(), "message");
	}

	@Parameters({ "browser" })
	@BeforeMethod(groups = { "open" })
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if (browserValue.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserValue.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(groups = { "open" })
	public void afterMethod(ITestResult itr) throws IOException {
		if (itr.getStatus() == ITestResult.FAILURE) {
			sh = new ScreenShotClass();
			sh.takeScreenShot(driver, itr.getName());
		}

		driver.close();
	}

}
