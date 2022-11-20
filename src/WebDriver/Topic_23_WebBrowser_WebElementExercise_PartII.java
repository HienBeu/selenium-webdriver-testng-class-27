package WebDriver;

import java.util.Random;
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
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstname,lastname,fullname,emailaddress,passworD,confirmpassword;				
	
	
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
	
	By emailAddress = By.id("email");
	By PasswordTextbox = By.id("pass");
	By loginButton = By.xpath("//div[@class='buttons-set']//span[text()='Login']");
	
	By FirstName = By.id("firstname");			
	By LastName = By.id("lastname");			
	By EmailAddress = By.id("email_address");			
	By PassWord = By.id("password");			
	By ConfirmPassword = By.id("confirmation");
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver/");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		rand = new Random();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstname = "Daoa";
		lastname = "b";
		fullname = firstname + " " + lastname;
		emailaddress = "nguyenhienit" + rand.nextInt(9999) + "@gmail.com";
		passworD = "123456";
		confirmpassword = "123456";
		
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
	//@Test
	public void TC_04_Register_funtion_at_MailChimp() {
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
	//@Test
	public void TC_05_login_with_empty_email_and_password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
		
	}
	//@Test
	public void TC_06_login_with_invalid_email() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(emailAddress).sendKeys("123434234@12312.123123");
		driver.findElement(PasswordTextbox).sendKeys("123456");
		driver.findElement(loginButton).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	//@Test
	public void TC_07_login_with_password_low_6_character() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(emailAddress).sendKeys("automation@gmail.com");
		driver.findElement(PasswordTextbox).sendKeys("123");
		driver.findElement(loginButton).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	
	//@Test
	public void TC_08_login_with_incorrect_emai_password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(emailAddress).sendKeys("automation@gmail.com");
		driver.findElement(PasswordTextbox).sendKeys("123123123");
		driver.findElement(loginButton).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(), "Invalid login or password.");
		
	}
	@Test
	public void TC_09_Create_a_new_account() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		driver.findElement(FirstName).sendKeys(firstname);
		driver.findElement(LastName).sendKeys(lastname);
		driver.findElement(EmailAddress).sendKeys(emailaddress);
		driver.findElement(PassWord).sendKeys(passworD);
		driver.findElement(ConfirmPassword).sendKeys(confirmpassword);
		
		driver.findElement(By.xpath("//button[@title='Register']//span")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).getText(), "Thank you for registering with Main Website Store.");
		
		String contactinformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();					
		Assert.assertTrue(contactinformation.contains(fullname));			
		Assert.assertTrue(contactinformation.contains(emailaddress));						
		
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//img[@src='http://live.techpanda.org/media/wysiwyg/test/logo.png']")).isDisplayed());
	}
	@Test
	public void TC_10_Login_with_valid_Email_and_passwword() {
		driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(emailAddress).sendKeys(emailaddress);
		driver.findElement(PasswordTextbox).sendKeys(passworD);
		driver.findElement(By.id("send2")).click();
		String contactinformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();					
		Assert.assertTrue(contactinformation.contains(fullname));			
		Assert.assertTrue(contactinformation.contains(emailaddress));	
		
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