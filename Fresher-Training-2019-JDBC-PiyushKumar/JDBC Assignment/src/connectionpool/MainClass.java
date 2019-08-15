package connectionpool;

import java.sql.SQLException;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of connection you wants to establish...");
		int noOfConn =sc.nextInt();
		
		ConnectionPool cp = new ConnectionPool();
		String user = "postgres";
		String password = "Welcome@123";
		String url = "jdbc:postgresql://127.0.0.1/postgres";

		for(int i=0;i<noOfConn;i++) {
			cp.createConn(url, user, password);
		}
		
		boolean flag =true;
		do {
			System.out.println();
			System.out.println("Selct the operation you want to execute");
			System.out.println("Press 1 for getConnection()...");
			System.out.println("Press 2  for returnConnection()...");
			System.out.println("Press 3 for getFreeConnectionCount()...");
			System.out.println("Press 4 for exit...");
			System.out.println();
			
			switch(sc.nextInt()) {
			case 1 : cp.getConnection();
					 break;
			case 2 : cp.returnConnection();
					 break;
			case 3 : cp.getFreeConnectionCount();
					 break;
			case 4 : flag = false;
					 break;
			default : System.out.println("You entered wrong input");
					  flag =false;
					  break;
			
			}
		}while(flag);
		
	}

}
