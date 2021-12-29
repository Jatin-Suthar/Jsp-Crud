package com.crud.conn;

import java.sql.*;
import java.util.*;

import com.crud.beans.User;

public class UserDao {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Jatin@300");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static int save(User u) {
		int status = 0;
		try {
			Connection conn = getConnection();
			String str = "insert into user(name,pass,gender,email,country)values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(str);
			//fill entry using user class
			ps.setString(1, u.getName());
			ps.setString(2, u.getPass());
			ps.setString(3, u.getGender());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getCountry());
			//execute update
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int updatePassword(User u, String newPassword) {
		int status = 0;
		try {
			Connection conn = getConnection();
			String str = "update user set pass=? where name = ?";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, newPassword);
			ps.setString(2, u.getName());
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int updateAllDetails(User u) {
		int status = 0;
		try {
			Connection conn = getConnection();
			String str = "update user set name=?,pass=?,gender=?,email=?,country=? where email=?";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPass());
			ps.setString(3, u.getGender());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getCountry());
			ps.setString(6, u.getEmail());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int deleteUser(User u) {
		int status = 0;
		try {
			Connection conn = getConnection();
			String str = "delete from user where name = ?";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, u.getEmail());
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List<User> getAllRecords(){
		List<User> list = new ArrayList<User>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				User u = new User();
				u.setName(res.getString("name"));
				u.setPass(res.getString("pass"));
				u.setGender(res.getString("gender"));
				u.setEmail(res.getString("email"));
				u.setCountry(res.getString("country"));
				list.add(u);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static User getUserByEmail(String email) {
		User u = null;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			u.setName(rs.getString("name"));
			u.setPass(rs.getString("pass"));
			u.setGender(rs.getString("gender"));
			u.setEmail(rs.getString("email"));
			u.setCountry(rs.getString("country"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}	
