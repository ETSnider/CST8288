package com.algonquin.gamehub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.algonquin.gamehub.beans.User;

public final class AuthenticationDao {
	
	public void createUser(String username, String password) {
		//add new user, store password hash with salt
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			String sql = "insert into users (username,passwod) values (?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(String username, String password) {
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			String sql = "update users set password=? where username=?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUser(String username) {
		User user = null;
		try {
			Connection conn = DBConnection.getConnectionToDatabase();
			
			String sql = "select * from users where username=?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				user = new User();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
