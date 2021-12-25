package net.rdczz.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.rdczz.usermanagement.model.User;

//CRUD OPERATIONS
public class UserDAO {
	//DATABASE DRIVER USERNAME & PASSWORD
	private String jdbcURL="jdbc:mysql://localhost:3306/webtech";
	private String jdbcUsername="root";
	private String jdbcPassword="Parzival_1025";
	//Database Queries
	private static final String INSERT_USERS_SQL="INSERT INTO empdetails"+"(name,email,country) VALUES"+"(?,?,?);";
	private static final String SELECT_ALL_USERS="SELECT * FROM empdetails";
	private static final String DELETE_USERS_SQL="DELETE FROM empdetails WHERE id=?;";
	private static final String UPDATE_USERS_SQL="UPDATE empdetails SET name=?,email=?,country? WHERE id=?;";
	
	//Connection method for database
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	//Database Operations :
	// create or insert user
	public void insertUser(User user) throws SQLException {
		try (Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(INSERT_USERS_SQL)){
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getCountry());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//select user by ID 
	//select users
	//update user
	//delete user
}
