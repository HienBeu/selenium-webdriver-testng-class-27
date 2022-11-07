package WebDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_WebBrowser_Commands {
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
		
		//3 câu lệnh này thường hay đi kèm với nhau 
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();//lúc nào cũng có câu này vì khi bật web lên thì web không có fullscreen
		//Cái nào tương tác với trình duyệt Brower thì sẽ thông qua biến WebDriver và đại diện tên biến là driver 
		//Cái nào tương tác với trình duyệt Element thì sẽ thông qua biến WebElement element
	}


	
	@Test
	public void TC_01_ID() {
		//Dùng cái driver và dùng dấu chấm để gọi đến hàm cho nó, truy cập đến các cái biến/ hàm trong WebDriver
		//Đóng trình duyệt
		//Nếu như có nhiều hơn 2 cửa sổ >=2: Nó sẽ đóng tab/ window mà nó đang đứng 
		// =1: Nó cũng đóng window
		driver.close();//**
		
		//Không quan tâm bao nhiêu tab/ window -> đóng hết tất cả cửa sổ 
		// =1: Nó cũng đóng window
		driver.quit();//**
		
		//- Có thể lưu nó vào 1 biến để sử dụng cho các step sau -> dùng lại nhiều lần 
		//Clean code 
		//Làm sao để code đúng và chạy được 
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email']"));//**
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		
		//Bad code
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		
		//Cần tìm hết tất cả các element
		List<WebElement> chekboxes = driver.findElements(By.xpath(""));//*
		
		//Mở ra 1 Url nào đó 
		driver.get("https://vi-vn.facebook.com/");//**
		
		// Click vào link: Tiếng Anh
		
		//Trả về Url của page hiện tại
		driver.getCurrentUrl();
		
		//verify
		Assert.assertEquals(driver.getCurrentUrl(), "https://en-gb.facebook.com/");
		
		//Trả về Source Code HTML của page hiện tại
		//Verify tương đối. Lấy ra 1 cái gì đó chứa thông tin 
		driver.getPageSource();
		
		Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn."));
		Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối "));
		Assert.assertTrue(driver.getPageSource().contains("chia sẻ với mọi người trong cuộc sống của bạn."));
		
		//Trả về title của page hiện tại
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "https://vi-vn.facebook.com/");
		
		//Được học trong bài WebDriver API - Window/Tabs
		//Lấy ra được ID của window/tab mà driver đang đứng (active)
		String loginWindowID = driver.getWindowHandle();//**
		
		//Được học trong bài WebDriver API - Window/Tabs
		//Lấy ra tất cả ID của Window/Tab đang đứng 
		Set<String> allID = driver.getWindowHandles();
		
		//Cookie/Cache
		Options opt = driver.manage();
		
		//Login thành công -> Lưu lại
		opt.getCookies();//*
		//Testcase khác -> Set cookie vào lại -> không cần phải login lại
		
		opt.logs();
		
		//Đặt biến
		Timeouts time = opt.timeouts();
		
		//Liên quan bài học: Implicit wait and  depend on: FindElement/FindElements
		//Khoảng thời gian dùng để chờ cho element xuất hiện trong vòng x giây
		time.implicitlyWait(15, TimeUnit.SECONDS);//**
		time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		time.implicitlyWait(5000000, TimeUnit.MICROSECONDS);
		
		//Khoảng thời gian dùng để chờ page load xong trong vòng x giây
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		

		//Liên quan bài học: WebDriver - Javascript Excutor (JavascriptExcutor library)
		//Khoảng thời gian dùng để chờ script được thực thi xong trong vòng x giây 
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		Window win = opt.window();
		win.fullscreen();
		win.maximize();//**
		
		
		//2 thằng này dùng để test giao diện GUI: Font/Size/Color/Position/Location....
		//nếu làm auto thường ưu tiên làm sau.Ưu tiên test Functional
		//set size là set kích thước bên trong của trình duyệt
		win.getSize();
		// set Position là set trình duyệt nằm ở tọa độ nào so với độ phân giải màn hình ở máy mình 
		win.getPosition();
		
		
		Navigation nvg = driver.navigate();
		nvg.back();
		nvg.refresh();
		nvg.forward();
		//https://prnt.sc/q672FjPXRX7H
		//2 thằng này như nhau nhưng cái thằng to support cho thằng history của 3  thằng trên tốt hơn 
		nvg.to("https://vi-vn.facebook.com/");
		driver.get("https://vi-vn.facebook.com/");
		
		TargetLocator tar = driver.switchTo();
		//Học trong bài: WebDriver API -Alert/ Authentication Alert (Alert library)
		tar.alert();//*
		
		//Học trong bài: WebDriver API - Frame/Iframe(Frame library)
		tar.frame("");
		
		//Học trong bài: WebDriver API -Window/ Tabs
		tar.window("");
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