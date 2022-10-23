package javaTester;

public class Topic_12_System {

	public static void main(String[] args) {
		// dang duoc luu o thu muc nao
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
        
		//Kiem tra he dieu hanh dang dung
		String osName = System.getProperty("os.name");
		System.out.println(osName);
	}

}
