package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22_WebBrower_WebElement_Exercise_PartI {
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
		driver.manage().window().maximize();
	}


	
	@Test
	public void TC_01_Browser_VerifyUrl_GetCurrentUrl() {
		driver.get("http://live.techpanda.org/");
		//Page Login
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		
		//Click vào My acccount
		//Truyền vào 1 sleep cứng khi chuyển trang. Lưu ý: hàm này nằm trong thằng java thread
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		
		//Click vào Create an acccount 
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
	}

	@Test
	public void TC_02_Browser_VerifyTitle_GetTitle() {
		driver.get("http://live.techpanda.org/");
		
		//Click vào My account 
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		 Assert.assertEquals(driver.getTitle(), "Customer Login");
		 
		 driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		 sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigate() {
		driver.get("http://live.techpanda.org/");
		
		//Click vào My account 
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
		//back lại
		driver.navigate().back();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.navigate().forward();
		 sleepInSecond(2);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
		
	}
	@Test
	public void TC_04_Get_page_source_code() {
		driver.get("http://live.techpanda.org/");
		
		//Click vào My account 
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		//Verify page HTML có chứa 1 chuỗi mong muốn
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		 driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		 sleepInSecond(3);
		 Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

		
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);//nhân với 1000 vì 1000ms mới = 1s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}