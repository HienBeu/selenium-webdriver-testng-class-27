package WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_25_Handle_Default_Dropdown {
	WebDriver driver;
	Select select;
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	String firstname, lastname, day, month, year, email, password, confirmpassword;
	String Firstname, Lastname, Email, Country, City, Address1, Zip, Phonenumber;
	
	//By Firstname = By.id("FirstName");				
	//By Lastname = By.id("LastName");				
	//By Day = By.name("DateOfBirthDay");				
	//By Month = By.name("DateOfBirthMonth");				
	//By Year = By.name("DateOfBirthYear");				
	//By Email = By.id("Email");				
	//By Pass = By.id("Password");				
	//By ConfirmPassword = By.id("ConfirmPassword");
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver/");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		
		driver = new FirefoxDriver();
		rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		firstname = "Nguyen";				
		lastname = "Hien";				
		day = "10";				
		month = "August";				
		year = "1915";				
		email = "nguyenhienit" + rand.nextInt(99999) + "@gmail.com";				
		password = "123456";				
		confirmpassword = "123456";
		
		//Addresses
		Firstname = "Ngoc"; 
		Lastname = "BaoAnh";
		Email = "BaoAnh" + rand.nextInt(99999) + "@gmail.com";
		Country = "Antigua and Barbuda"; 
		City = "Vietnam";
		Address1 = "367 binh da binh minh thanh oai ha noi";
		Zip = "880000";
		Phonenumber = "0374619213";
	
	}


	@Test
	public void TC_01_ID() {
		driver.get("https://demo.nopcommerce.com/");				
		driver.findElement(By.xpath("//a[text()='Register']")).click();			
		sleepInSecond(3);
						
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);				
		new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);		
		new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);		
		new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);		
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);	
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmpassword);				
								
		driver.findElement(By.xpath("//button[text()='Register']")).click();				
		sleepInSecond(3);				
								
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");			
								
		driver.findElement(By.cssSelector("a.ico-account")).click();				
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstname);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastname);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);

	}

	@Test
	public void TC_02_() {
		
		driver.findElement(By.xpath("//div[@class='listbox']//a[text()='Addresses']")).click();
		driver.findElement(By.xpath("//button[text()='Add new']")).click();
		driver.findElement(By.id("Address_FirstName")).sendKeys(Firstname);
		driver.findElement(By.id("Address_LastName")).sendKeys(Lastname);
		driver.findElement(By.id("Address_Email")).sendKeys(Email);
		new Select(driver.findElement(By.name("Address.CountryId"))).selectByVisibleText(Country);
		driver.findElement(By.id("Address_City")).sendKeys(City);
		driver.findElement(By.id("Address_Address1")).sendKeys(Address1);
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(Zip);
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(Phonenumber);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.name")).getText(), Firstname + " " + Lastname);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.email")).getText().contains(Email));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.phone")).getText().contains(Phonenumber));
		Assert.assertEquals(driver.findElement(By.cssSelector("li.address1")).getText(), Address1);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains(City));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains(Zip));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.country")).getText().contains(Country));
		
		
	}

	public int randomNumber() {		
		Random rand = new Random();	
		return rand.nextInt(99999);	
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