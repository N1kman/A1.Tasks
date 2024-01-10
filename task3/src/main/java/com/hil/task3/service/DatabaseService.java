package com.hil.task3.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import java.sql.*;
import com.hil.task3.entity.Login;
import com.hil.task3.entity.Posting;

@Service
public class DatabaseService {
	
	public void safeToDatabasePostings(ArrayList<Posting> list) {
		String url = "jdbc:mysql://localhost:3306/a1";
        String user = "root";
        String password = "192837465";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            for(Posting posting: list) {
                String query = "INSERT INTO posting (mat_doc, item, doc_date, pstng_date, description, quantity, bun, amount_LC, crcy, username, authorized_delivery) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, posting.getMat_doc());
                statement.setInt(2, posting.getItem());
                statement.setString(3, posting.getDoc_date());
                statement.setString(4, posting.getPstng_date());
                statement.setString(5, posting.getDescription());
                statement.setInt(6, posting.getQuantity());
                statement.setString(7, posting.getBun());
                statement.setFloat(8, posting.getAmount_LC());
                statement.setString(9, posting.getCrcy());
                statement.setString(10, posting.getUsername());
                statement.setBoolean(11, posting.isAuthorized_delivery());
                statement.executeUpdate();
            }            

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void safeToDatabaseLogins(ArrayList<Login> list) {
		String url = "jdbc:mysql://localhost:3306/a1";
        String user = "root";
        String password = "192837465";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            for(Login login: list) {
                String query = "INSERT INTO logins (application, appAccountName, isActive, jobTitle, department) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, login.getApplication());
                statement.setString(2, login.getAppAccountName());
                statement.setBoolean(3, login.isActive());
                statement.setString(4, login.getJobTitle());
                statement.setString(5, login.getDepartment());
                statement.executeUpdate();
            }            

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public ArrayList<Posting> readFromDatabasePostings() {
		ArrayList<Posting> list =  new ArrayList<Posting>();
		String url = "jdbc:mysql://localhost:3306/a1";
	    String username = "root";
	    String password = "192837465";
	    
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement(); 
			String sql = "SELECT * FROM posting";
		    ResultSet rs = statement.executeQuery(sql);

		    while (rs.next()) {
		    	Posting post = new Posting();
		    	post.setMat_doc(rs.getLong("mat_doc"));    
		   		post.setItem(rs.getInt("item"));
		   		post.setDoc_date(rs.getString("doc_date"));
		        post.setPstng_date(rs.getString("pstng_date"));
		        post.setDescription(rs.getString("description"));
		        post.setQuantity(rs.getInt("quantity"));
		        post.setBun(rs.getString("bun"));
		        post.setAmount_LC(rs.getFloat("amount_LC"));
		        post.setCrcy(rs.getString("crcy"));
		        post.setUsername(rs.getString("username"));
		        post.setAuthorized_delivery(rs.getBoolean("authorized_delivery"));
		        list.add(post);
		    }

		    rs.close();
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    System.out.println(e);
		}
		return list;
	}
}
