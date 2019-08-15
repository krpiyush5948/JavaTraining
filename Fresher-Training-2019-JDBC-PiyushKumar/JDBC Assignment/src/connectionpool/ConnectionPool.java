package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

public class ConnectionPool {
	
	Stack<Connection> activeConn = new Stack<>();
	Stack<Connection> freeConn = new Stack<>(); 
	
	public void createConn(String url,String uname,String pass) throws SQLException {
		freeConn.add(DriverManager.getConnection(url, uname, pass));
	}

	public void getConnection(){
		if(freeConn.size() != 0) {
			activeConn.push(freeConn.pop());
			System.out.println("Added in Connection Pool...");
		}
		else {
			System.out.println("Free Connections aren't Available...");
		}
		
	}
	
	 public void returnConnection(){
		if(activeConn.size()!=0) {
			freeConn.push(activeConn.pop());
			System.out.println("Added in Free Connections...");
		}
		else {
			System.out.println("No active connections....");
		}
	}
	
	void getFreeConnectionCount(){
		System.out.println("Number of free Connections Available in connection pool is : "+freeConn.size());
	}

}
