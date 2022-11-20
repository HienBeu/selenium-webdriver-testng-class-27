package javaTester;

import java.util.Random;

public class Topic_23_random {

	public static void main(String[] args) {
		//thư viện liên quan đến tiện ích 
		//Dùng cho các trường hợp mà là duy nhất và không trùng nhau: Ví dụ: ID/ email
		//Có thể tạo ra nhiều đối tượng khác nhau
		//Là 1 data type: class/ interface/ collection/ string/float/....
		//Double/Float -> kiểu số thực
		//int/byte/short/long: kiểu số nguyên
		//1 email không nên có 1 số thập phân
		//có những email không có dấu chấm. Email thường dùng thằng int hặc long
		//.net.. : tạo ra 1 số nằm trong cái khoảng. Ví dụ Double: (((long)next(26) << 27) + next(27))
		Random rand = new Random();
		System.out.println(rand.nextDouble());
		System.out.println(rand.nextFloat());
		System.out.println(rand.nextInt(9999));
		System.out.println("nguyenhienit" + rand.nextInt(9999) + "@gmail.com");
		System.out.println(rand.nextLong());
		
		//hien-8108257149586032035@gmail.com => email không hợp lệ 
		//hien0.3702463883344431@gmail.com => email không hợp lệ 
		//hien0.732567@gmail.com => email không hợp lệ 
		//hien1500291498@gmail.com => email này sẽ ít lỗi nhất nên sẽ dùng thằng nextInt -> vì mỗi lần chạy sẽ ra 1 số tự động khác nhau
		//Không nên dùng nextInt thuần vì có lúc nó chạy ra dãy có 10 số dương, lúc thì chạy ra số âm
		//nếu muốn nextInt luôn ra 5 số từ 1 -> 9999 thì để 4 số 9, 3 số 9 hoặc 5 số 9 tùy theo.Nên để 4 số 9 hoặc 5 số 9
		
	}
}
