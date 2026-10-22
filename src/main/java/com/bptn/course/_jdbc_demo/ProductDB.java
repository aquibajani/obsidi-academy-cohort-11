package com.bptn.course._jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDB {
	private static final String userName = "postgres";
	private static final String password = "pg123";
	private static final String dbName = "product";
	private static final String port = "5432";
	private static final String dbUrl = "localhost";
	
	public Connection createConnection() {
		  Connection conn = null;
		  try {
		      // These lines load the postgresql driver, then initialize it with the variables we defined above:
		    //Class.forName("org.postgresql.Driver");
		    conn = DriverManager
		      .getConnection("jdbc:postgresql://" + dbUrl + ":" + port + "/" + dbName,
		        userName, password);
		  } catch (Exception e) {
		    System.out.println(e.getClass().getName() + ": " + e.getMessage());
		    System.exit(0);
		  }
		  System.out.println("Opened database successfully");
		  return conn;
		}
	
	public void getAllProducts(Connection conn) {
		  try {
		    Statement stmt = conn.createStatement();
		      // This line creates our SQL statement to select all entries from the student table:
		    String sql = "SELECT * FROM dairy_products";
		      // This line executes the query in the line above, setting its results to a ResultSet object called rs:
		    ResultSet rs = stmt.executeQuery(sql);
		      // While there is data in the returned result set, we will print that line to the console:
		    while (rs.next()) {
		      // Retrieve by column name
		      System.out.print("Product ID: " + rs.getInt("product_id"));
		      System.out.print(", Product Name: " + rs.getString("product_name"));
		      System.out.print(", Product Quantity: " + rs.getInt("product_quantity"));
		      System.out.println(", Product Price: " + rs.getFloat("product_price"));
		    }
		      // Here, we close our connection:
		    stmt.close();
		  } catch (SQLException ex) {
		    // And of course, we handle exceptions in case our query is unsuccessful: 
		    System.out.println("Exception:" + ex.getMessage());
		  }
		}
	
	public void getProductById(Connection conn, Integer product_id) {
		  try {
		      // This is a prepared statement. We'll go into more detail on these in the next lesson, so don't worry too much about exactly how it works right now. Just try to figure out how it's being used, and how the ? relates to what's going on:
			  String sql = "SELECT * FROM dairy_products WHERE \"product_id\" = ?";
			  PreparedStatement stmt = conn.prepareStatement(sql);
		      // Note: we're using s so Java interprets our "" properly:
		    
		    stmt.setInt(1, product_id);  // 1 specifies the first parameter in the query
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		      System.out.print("Product ID: " + rs.getInt("product_id"));
		      System.out.print(", Product Name: " + rs.getString("product_name"));
		      System.out.print(", Product Quantity: " + rs.getInt("product_quantity"));
		      System.out.println(", Product Price: " + rs.getFloat("product_price"));
		    }
		    stmt.close();
		  } catch (SQLException ex) {
		    System.out.println("Exception:" + ex.getMessage());
		  }
		}

	public boolean closeConnection(Connection conn) {
		  boolean flag = true;
		  try {
		    conn.close();
		  } catch (SQLException ex) {
		    flag = false;
		    // Handle exception, in case of any errors:
		    System.out.println("Exception:" + ex.getMessage());
		  }
		  return flag;
		}
}
