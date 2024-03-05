package myPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Student {
	public void createDatabase()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String username = "root";
			String password = "nandan5231";
			
			Connection conn = DriverManager.getConnection(url,username,password);
			//Statement Create
			Statement stm = conn.createStatement();
			//Execute Querry
			String querry = "create database Tutorial";
			stm.execute(querry);
			
			System.out.println("Connected Successfully.");
			//Close Connection
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void createTable() {
			try {
				String url = "jdbc:mysql://localhost:3306/Tutorial";
				String username = "root";
				String password = "nandan5231";
				
				Connection conn = DriverManager.getConnection(url,username,password);
				//Statement Create
				Statement stm = conn.createStatement();
				//Execute Querry
				String querry = "create table student(sid int(3), sname varchar(20), semail varchar(200))";
				stm.execute(querry);
				
				System.out.println("Table created Successfully.");
				//Close Connection
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	public void createData() {

			try {
				String url = "jdbc:mysql://localhost:3306/";
				String db = "Tutorial";
				String username = "root";
				String password = "nandan5231";
				
				Connection conn = DriverManager.getConnection(url+db,username,password);
				
				//Statement Create
				//Statement stm = conn.createStatement();
				
				
				//Execute Querry
				String querry = "Insert into student (sid, sname, semail) VALUES (?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(querry);
					pstm.setInt(1,2);
					pstm.setString(2, "Shivam");
					pstm.setString(3, "Shivam@gmail.com");
					pstm.execute();
				
				//stm.execute(querry);
				
				System.out.println("Data Inserted Successfully.");
				//Close Connection
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}
	public void readData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "Tutorial";
			String username = "root";
			String password = "nandan5231";
			
			Connection conn = DriverManager.getConnection(url+db,username,password);
			
			//Statement Create
			Statement stm = conn.createStatement();
			
			
			//Execute Querry
			String querry = "select * from student";
			/*
			 * PreparedStatement pstm = conn.prepareStatement(querry); pstm.setInt(1,2);
			 * pstm.setString(2, "Shivam"); pstm.setString(3, "Shivam@gmail.com");
			 * pstm.execute();
			 */
			
			
			ResultSet rs = stm.executeQuery(querry);
			while(rs.next()) {
				System.out.println("ID = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("E-mail Address = " + rs.getString(3));
			}
			
			System.out.println("Data Readed Successfully.");
			//Close Connection
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public void updateData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "Tutorial";
			String username = "root";
			String password = "nandan5231";
			
			Connection conn = DriverManager.getConnection(url+db,username,password);
			
			//Statement Create
			//Statement stm = conn.createStatement();
			
			
			//Execute Querry
			String querry = "UPDATE student set sid = ? where sname = ? ";
			PreparedStatement pstm = conn.prepareStatement(querry);
				pstm.setInt(1,2);
				pstm.setString(2, "Shivam");
				
				pstm.execute();
			
			//stm.execute(querry);
			
			System.out.println("Data Updated Successfully.");
			//Close Connection
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "Tutorial";
			String username = "root";
			String password = "nandan5231";
			
			Connection conn = DriverManager.getConnection(url+db,username,password);
			//Statement Create
			Statement stm = conn.createStatement();
			//Execute Querry
			String querry = "DELETE from student where sid = 1";
			stm.execute(querry);
			
			System.out.println("Data Deleted Successfully.");
			//Close Connection
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
