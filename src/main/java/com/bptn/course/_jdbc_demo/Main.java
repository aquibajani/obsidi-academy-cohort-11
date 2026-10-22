package com.bptn.course._jdbc_demo;

//Your package name goes here

import java.sql.Connection;

public class Main {
  public static void main(String[] args) {
	  ProductDB jdbc = new ProductDB();
      Connection conn = jdbc.createConnection();
      jdbc.getAllProducts(conn);
      jdbc.closeConnection(conn);
  }
}