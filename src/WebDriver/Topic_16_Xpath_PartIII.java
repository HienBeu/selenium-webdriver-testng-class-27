package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Xpath_PartIII {
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
	public void TC_01_Register_with_empty_data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ']/parent::div[@class='field_btn']/ancestor::div[@class='form frmRegister']")).click();
		driver.findElement(By.xpath("//div[@class='form frmRegister']//div[@class='field_btn']/button")).click();
		//verify
		//Assert.assertTrue -> kiểm tra 1 điều kiện trả về là đúng
		//Assert.assertFalse -> kiểm tra 1 điều kiện trả về là sai
		//Assert.assertEquals -> kiểm tra thực tế với mong đợi như nhau
		//Actual Result = Expected Result -> hàm assertEquals là dùng cho cái này 
		
		//Data Type: WebElement = String
		//Data Type: String = String
		//Data Value: Vui lòng nhập họ tên =  vui lòng nhập họ tên
		
		//Assert.assertEquals(driver.findElement(By.id("//label[@id='txtFirstname-error']")).getText(), "Vui lòng nhập họ tên");
		//Assert.assertEquals(driver.findElement(By.id("//label[@id='txtEmail-error']")).getText(), "Vui lòng nhập họ tên");
		//Assert.assertEquals(driver.findElement(By.id("//label[@id='txtCEmail-error']")).getText(), "Vui lòng nhập họ tên");
		//Assert.assertEquals(driver.findElement(By.id("//label[@id='txtPassword-error']")).getText(), "Vui lòng nhập họ tên");
		//Assert.assertEquals(driver.findElement(By.id("//label[@id='txtPassword-error']")).getText(), "Vui lòng nhập họ tên");
		//Assert.assertEquals(driver.findElement(By.id("//label[@id='txtPhone-error']")).getText(), "Vui lòng nhập họ tên");
		
		 Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Register_with_invalid_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Hien");
		driver.findElement(By.id("txtEmail")).sendKeys("123@456@789");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@456@789");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0384619213");
		
		driver.findElement(By.xpath("//div[@class='form frmRegister']//div[@class='field_btn']/button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}

	@Test
	public void TC_03_Register_with_incorrect_confirm_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Hien");
		driver.findElement(By.id("txtEmail")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhienit94@gmail.net");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0384619213");
		
		driver.findElement(By.xpath("//div[@class='form frmRegister']//div[@class='field_btn']/button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}
	@Test
	public void TC_04_Register_with_password_duoi_6_ki_tu() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Hien");
		driver.findElement(By.id("txtEmail")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("0384619213");
		
		driver.findElement(By.xpath("//div[@class='form frmRegister']//div[@class='field_btn']/button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		
	}
	
	@Test
	public void TC_05_incorrect_confirm_password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Hien");
		driver.findElement(By.id("txtEmail")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhienit94@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123457");
		driver.findElement(By.id("txtPhone")).sendKeys("0384619213");
		
		driver.findElement(By.xpath("//div[@class='form frmRegister']//div[@class='field_btn']/button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_invalid_phone_number() {
		   driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			
			driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Thi Hien");
			driver.findElement(By.id("txtEmail")).sendKeys("nguyenhienit94@gmail.com");
			driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhienit94@gmail.com");
			driver.findElement(By.id("txtPassword")).sendKeys("123456");
			driver.findElement(By.id("txtCPassword")).sendKeys("123456");
			driver.findElement(By.id("txtPhone")).sendKeys("038461921");
			
			driver.findElement(By.xpath("//div[@class='form frmRegister']//div[@class='field_btn']/button")).click();
			
			Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
			
			driver.findElement(By.id("txtPhone")).clear();
			driver.findElement(By.id("txtPhone")).sendKeys("0133756152");
			
			Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
			
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}