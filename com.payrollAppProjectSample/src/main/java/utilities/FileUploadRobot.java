package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadRobot {
	//public static void main(String[] args) throws AWTException, InterruptedException {
		
		public void fileUploadMethod() throws AWTException, InterruptedException{
			
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		
		// creating object of Robot class
		Robot rb = new Robot();

		// Store the File path to the StringSelection class
		StringSelection filePath = new StringSelection("C:\\Users\\dell\\Desktop\\Obsqura SE Notes\\Scrolling PDF.pdf");

		//Copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("file uploaded..");
		
		driver.quit();
		}
	//}

}
