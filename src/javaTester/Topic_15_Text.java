package javaTester;

public class Topic_15_Text {

	public static void main(String[] args) {
		//Xử dụng cho cái tính đúng sai:
		//Kiểu dữ liệu đại diện là: boolean
		boolean statusA;
		boolean statusB;
		
		// And -> kí hiệu là &&
		// And có quy ước như  sau: 
		// Nếu 1 trong 2 điều kiện sai -> kết quả sai
		// Nếu 1 trong 2 điều kiện đúng -> kết quả sai 
		// Cả 2 đều sai -> kết quả sai
		// cả 2 điều kiện đúng -> mới ra đúng
		statusA = true;
		statusB = false;
		System.out.println("Kết quả = " + (statusA && statusB));
		
		statusA = false;
		statusB = true;
		System.out.println("Kết quả = " + (statusA && statusB));
		
		statusA = false;
		statusB = false;
		System.out.println("Kết quả = " + (statusA && statusB));
		
		statusA = true;
		statusB = true;
		System.out.println("Kết quả = " + (statusA && statusB));
		
		
		//Or -> kí hiêu ||
		// Nếu 1 trong 2 điều kiện sai -> kết quả đúng
		// Nếu 1 trong 2 điều kiện đúng -> kết quả đúng
		// Cả 2 đều sai -> kết quả sai
		// cả 2 điều kiện đúng -> kết quả đúng đúng
		statusA = true;
		statusB = false;
		System.out.println("Kết quả = " + (statusA || statusB));
		
		statusA = false;
		statusB = true;
		System.out.println("Kết quả = " + (statusA || statusB));
		
		statusA = false;
		statusB = false;
		System.out.println("Kết quả = " + (statusA || statusB));
		
		statusA = true;
		statusB = true;
		System.out.println("Kết quả = " + (statusA || statusB));
	}
}
