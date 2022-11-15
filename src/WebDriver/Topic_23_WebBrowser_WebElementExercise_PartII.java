package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_23_WebBrowser_WebElementExercise_PartII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By emailTextbox = By.id("mail");
	By radiocheckbox = By.id("under_18");
	By EduTextarea = By.id("edu");
	By javaCheckbox = By.id("java");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By JobRole01Dropdown = By.id("job1");
	By JobRole02MultipleDropdown = By.id("job2");
	By developmentCheckbox = By.id("development");
	By slider1 = By.id("slider-1");
	By password = By.id("disable_password");
	By ageradiobutton = By.id("radio-disabled");
	By BiographyTextarea = By.id("bio");
	By JobRole03 = By.id("job3");
	By Checkboxisdisable = By.id("check-disbaled");
	By slider2 = By.id("slider-2");
	
	By passwordInput = By.id("new_password");
	By buttonSignUp = By.id("create-account-enabled");
	
	
	
	
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


	
	//@Test
	public void TC_01_Displayed_isDisplayed() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Email
		if(driver.findElement(emailTextbox).isDisplayed()){
			driver.findElement(emailTextbox).sendKeys("Automation Testing");
			System.out.println("emai textbox is displayed");
		}else {
			System.out.println("emai textbox is not displayed");
		}
		
		//Kiểm tra Education
		if(driver.findElement(EduTextarea).isDisplayed()){
			driver.findElement(EduTextarea).sendKeys("Automation Testing");
			System.out.println("Edu textarea is displayed");
		}else {
			System.out.println("Edu textarea is not displayed");
		}
		
		//Age
		if(driver.findElement(radiocheckbox).isDisplayed()){
			driver.findElement(radiocheckbox).click();
			System.out.println("radio checkbox is displayed");
		}else { 
			System.out.println("radio checkbox is not displayed");
			
		//Name
		if(driver.findElement(nameUser5Text).isDisplayed()){
			System.out.println("name User5 Text is displayed");
		}else{
			System.out.println("name User5 Text is not displayed");
			}
		}
	}

	//@Test
	public void TC_02_Enabled_isEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(emailTextbox).isEnabled()) {
			System.out.println("email textbox is enabled");
		}else
			System.out.println("email textbox is not enabled");
		
		if(driver.findElement(radiocheckbox).isEnabled()) {
			System.out.println("radio checkbox is enabled");
		}else
			System.out.println("radio checkbox is not enabled");
		
		if(driver.findElement(EduTextarea).isEnabled()) {
			System.out.println("Edu Textarea is enabled");
		}else
			System.out.println("Edu Textarea is not enabled");
		
		if(driver.findElement(JobRole01Dropdown).isEnabled()) {
			System.out.println("JobRole 01 is enabled");
		}else
			System.out.println("JobRole 01 is not enabled");
		
		if(driver.findElement(JobRole02MultipleDropdown).isEnabled()) {
			System.out.println("JobRole02 MultipleDropdown is enabled");
		}else
			System.out.println("JobRole02 MultipleDropdown is not enabled");
		
		if(driver.findElement(developmentCheckbox).isEnabled()) {
			System.out.println("development Checkboxemail textbox is enabled");
		}else
			System.out.println("development Checkbox is not enabled");
		

		if(driver.findElement(password).isEnabled()) {
			System.out.println("pass is enabled");
		}else
			System.out.println("pass is not enabled");
		
		if(driver.findElement(ageradiobutton).isEnabled()) {
			System.out.println("ageradio button is enabled");
		}else
			System.out.println("ageradio button is not enabled");
		
		if(driver.findElement(BiographyTextarea).isEnabled()) {
			System.out.println("Biography Textarea is enabled");
		}else
			System.out.println("Biography Textarea is not enabled");
		
		if(driver.findElement(JobRole03).isEnabled()) {
			System.out.println("JobRole 03 is enabled");
		}else
			System.out.println("JobRole 03 is not enabled");
		
		if(driver.findElement(Checkboxisdisable).isEnabled()) {
			System.out.println("Checkbox is enabled");
		}else
			System.out.println("Checkbox is not enabled");
		
		if(driver.findElement(slider2).isEnabled()) {
			System.out.println("slider2 is enabled");
		}else
			System.out.println("slider2 is not enabled");
	}

	//@Test
	public void TC_03_selected_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Assert.assertFalse(driver.findElement(radiocheckbox).isSelected());
		Assert.assertFalse(driver.findElement(javaCheckbox).isSelected());
		
		driver.findElement(radiocheckbox).click();
		driver.findElement(javaCheckbox).click();
		
		Assert.assertTrue(driver.findElement(radiocheckbox).isSelected());
		Assert.assertTrue(driver.findElement(javaCheckbox).isSelected());
		
		
	
		
	}
	@Test
	public void TC_04_() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.cssSelector("#email")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(passwordInput).sendKeys("123");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys("abc");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys("ABC");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys("!@#");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys("DFGCHKKLLLLLLSLSKSS");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys("abcA!@bhs12");
		sleepInSecond(3);
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
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