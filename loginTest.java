import java.util.Scanner;


public class loginTest implements login {
	

	

	


	public static void main(String[] args){
		loginTest loginTest = new loginTest();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your username: ");
		String username = input.nextLine();
		System.out.print("Please enter your password: ");
		String password = input.nextLine();
		loginTest.userLogin(username, password);
		
	}

	
	public boolean userLogin (String username, String password){
		String adminUser = "admin";
		String studentUser = "student";
		String pass = "1234";
		if (username.equals(adminUser) || username.equals(studentUser){
			if (password.equals(pass)){
				System.out.print("Successful login\n");
				return true;
			}
			else {System.out.print("Incorrect password\n");
				return false;}
		}
		else{System.out.print("Incorrect username\n");
			return false;}				
	}
	
}
