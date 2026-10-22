package com.bptn.course._feedApp_db;

import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		FeedAppDB jdbc = new FeedAppDB();
	    Connection conn = jdbc.createConnection();
	    jdbc.addUser(conn, "Ray", "Mist", "raymist", "18292831", "ray@mist.com", "Ray@22", true);
	    jdbc.closeConnection(conn);
	}
}