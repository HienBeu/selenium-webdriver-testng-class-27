package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_19_Run_On_Brower {
	WebDriver driver;
	//Lấy ra đường dẫn của project(projectPath): System.getProperty("user.dir");
	//dùng windown:
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
		//Để chạy cho 1 trình duyệt nào cũng cần có 1 driver
	    //geckodriver.exe -> gọi là executable file -> chính là file thực thi để giao tiếp được với trình duyệt
		//Trên windown muốn đi tiếp vào 1 thư mục thì phải dùng dấu 2 \\
		//FirefoxDriver -> đây là cái code. Là cái thư viện của selenium có tên là FirefoxDriver. Đây là 1 cái class -> thư viện của selenium

	
	@Test
	public void TC_01_Run_Chrome() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");	
		}
		driver = new ChromeDriver();
		driver.get("https://vi-vn.facebook.com/");
		driver.quit();

	}

	@Test
	public void TC_02_Run_Firefox() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodrive");	
		}
		driver = new FirefoxDriver();
		driver.get("https://vi-vn.facebook.com/");
		driver.quit();
	}

	@Test
	public void TC_03_Run_Edge() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		}else {
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
		}
		driver = new EdgeDriver();
		driver.get("https://vi-vn.facebook.com/");
		driver.quit();
	}
}