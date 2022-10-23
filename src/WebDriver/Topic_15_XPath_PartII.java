package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_XPath_PartII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver/");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	
	@Test
	public void TC_01_ID() {
		driver.get("https://automationfc.github.io/basic-form/");
		
		
		System.out.println("Xin chao cac  ban lop Automation Test 27");
		
		System.out.println("Xin chao cac  ban" + " lop Automation Test " + "27");
		
	    System.out.println("Text của thẻ h5:" + driver.findElement(By.xpath("//h5[@id='nested']")).getText());
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}