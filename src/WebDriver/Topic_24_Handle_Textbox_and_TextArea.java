package WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_Handle_Textbox_and_TextArea {
	WebDriver driver;
	Random rand;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String EmployeeID;
	String passportNumber, commentInput;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver/");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		rand= new Random();
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		EmployeeID = String.valueOf(rand.nextInt(9999));
		passportNumber = "99603 574-32-8843";
		commentInput ="This is generated data of real people, the database looks like 2017-2018 \nHere you can make a test generation,the data falls out";
	}


	
	@Test
	public void TC_01_Create_New_Employee() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		sleepInSecond(6);
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.name("firstName")).sendKeys("Gaobe");
		driver.findElement(By.name("lastName")).sendKeys("23");
		
		WebElement employeeIDTextbox = driver.findElement(By.xpath("//label[@class='oxd-label']/parent::div/following-sibling::div/input"));
		employeeIDTextbox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		employeeIDTextbox.sendKeys(Keys.DELETE);
		employeeIDTextbox.sendKeys(EmployeeID);
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys("afc" + EmployeeID);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys("Gao@2021");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys("Gao@2021");
		driver.findElement(By.xpath("//button[contains(.,' Save ')]")).click();
		sleepInSecond(8);
		
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Gaobe");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "23");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@class='oxd-label']/parent::div/following-sibling::div/input")).getAttribute("value"), EmployeeID);
		
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/parent::div//button")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(commentInput);
		driver.findElement(By.xpath("//button[contains(.,' Save ')]")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), "passportNumber");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), "commentInput");
		driver.findElement(By.cssSelector("oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.name("username")).sendKeys("afc" + EmployeeID);
		driver.findElement(By.name("password")).sendKeys("Gao@2021");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		sleepInSecond(6);
		
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Gaobe");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "23");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@class='oxd-label']/parent::div/following-sibling::div/input")).getAttribute("value"), EmployeeID);
		
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), "passportNumber");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), "commentInput");
		
		
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
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
		//driver.quit();
	}
}