package javaTester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_13_DataType {
	//Data type -> gọi là kiểu dữ liệu

	public static void main(String[] args) {
		//I. Kiểu dữ liệu nguyên thủy (Primitive)
		
		// Số nguyên: Byte, short, int, long (không có phần thập phân: 22, 100, 1000, 105 -> tức là không có dấu chấm. Ví dụ như số lượng học sinh trong 1 lớp, số nvien trong 1 công ty)
		  
		// + Byte: Lưu trữ khoảng 256 số  Ví dụ như mua 1 quả dưa hấu xong cho 1 túi nilong mang về -> mua với số lượng ít
		  byte bNumber = 127;
		
	   // short: mua 10 quả -> cần 1 thùng caton hoặc 1 bao lớn đựng gạo -> sau đó trở về
		  short sNumber = 32000;
		
	   //int: Cần mua 100 quả dưa hấu -> thuê xe oto chuyển hàng nhỏ chở cả 100 quả -> chở về
		  int iNumber = 499923329;
		 
	  //long: mua nguyên 1 ha dưa hấu -> cần 1 conteno để trở hết hàng mang sang TQ bán 
		  long lNumber = 83294; 
		  //-> hay báo lỗi nhưng thực chất nó lưu được dữ liệu lớn 
		
		
	  // Số thực: Float, double (có phần thập phân. Ví dụ: 10.5 / 15.5 -> ví dụ như ngân hàng, tính lương nhân viên trong 1 công ty -> nên phải lưu kiểu số thực để ra 1 con số chính xác)
	  // => tương tự như kiểu số nguyên 
		  //float
		  float studentPoint = 9.5f;
		  //double
		  double employeeSalary= 35.6d;
		  //=> Để phân biệt float hay double thì  sau số có chữ f hoặc d
		  
		  
		// Logic: boolean
		//boolean: Xử dụng cho TH với dữ liệu nào đó đúng hoặc sai -> VD: như bài toán tính điểm để tính xem bao nhiêu câu đúng/sai. 
		// Thi cử hoặc giới tính: nam or nữ"
		  boolean status = true; //Nam
		  status = false; //Nữ
		
		// Kí tự: char
		  char a ='A';
		
		//II.  Kiểu dữ liệu tham chiếu (Reference)
		  //Class 
		  FirefoxDriver driver = new FirefoxDriver();
		  
		  //Interface	
		  WebElement firstNameTextbox;
		  
		  //String
		  String firstName = "Automation Testing";
		  
		  //Object 
		  	Object people;
		  	
		  // Array 
		  	String[] studentName = {"Nguyễn Văn An", "Lê Văn Hùng", "Nguyễn Thị Loan"};
		  	
		  //Collection: List/Set/Queue
		  	List<WebElement> checkboxes = driver.findElements(By.cssSelector(""));
		 
		  	//Map	
		  	Map<String, Integer> student = new HashMap<String, Integer>();
	}

}
