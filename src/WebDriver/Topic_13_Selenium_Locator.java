package WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Selenium_Locator {
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
		//Mở trang register ra
		driver.get("https://demo.nopcommerce.com/register");
	}

	//HTML của FirstName textbox
	// <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
	// id="FirstName" name="FirstName"
	
	// Tên thẻ của element (Tagname HTML) -> input
	// Tên của thuộc tính (Attribute name) -> type, data-val-required, data-val
	// Giá trị của thuộc tính (Attribute value) -> First name is required., FirstName 
	
	@Test
	public void TC_01_ID() {
		//- Muốn thao tác lên element -> thì phải tìm lên cái element đó -> findElement
		//- Find theo cái gì: id/ class/ name/ css/ xpath/...
		//- Sau khi find tìm thấy element rồi thì action lên element đó: click, sendkey,...
		driver.findElement(By.id("FirstName")).sendKeys("Automation");

	}

	@Test
	public void TC_02_Class() {
		//Mở màn hình search 
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("Macbook");
	}

	@Test
	public void TC_03_name() {
		//Click vào Advanced Search checkbox
		driver.findElement(By.name("advs")).click();
	}
	
	@Test
	public void TC_04_TagName() {
		//Tìm ra bao nhiêu thẻ input trên màn hình hiện tại 
		//Lấy ra số lượng element trên MH là bao nhiêu 
		System.out.println(driver.findElements(By.tagName("input")).size());
		
	}
	
	@Test
	public void TC_05_LinkText() {
		//Click vào đường link Address -> truyền vào text tuyệt đối -> chứa toàn bộ 
		driver.findElement(By.linkText("Addresses")).click();
	
	}
	
	@Test
	public void TC_06_PartialLinkText() {
		//Click vào đường link Address -> truyền vào text tương đối  -> chứa 1 phần -> không cần lấy toàn bộ chuỗi -> nhưng mà nó sẽ chạy chậm hơn 
		driver.findElement(By.partialLinkText("vendor account")).click();
	}
	
	@Test
	public void TC_07_Css() {
		//Mở lại trang Register
		driver.get("https://demo.nopcommerce.com/register");
		
		//Các cách viết 
		//1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
		
		//2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
		
		//2
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("automation@gmail.com");
	}
	
	@Test
	public void TC_08_Xpath() {
		//Mở lại trang Register
		driver.get("https://demo.nopcommerce.com/register");
				
		//Các cách viết 
		//1
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Selenium");
				
		//2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");
				
		//2
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("automation@gmail.com");
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}