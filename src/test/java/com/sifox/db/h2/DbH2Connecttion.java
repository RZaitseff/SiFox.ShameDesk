package com.sifox.db.h2;

import java.sql.*;

public class DbH2Connecttion {

	    public static void main(String[] a) throws Exception {
	        Class.forName("org.h2.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	        System.out.println("getConnection( to 'jdbc:h2:~/test");
	        conn.close();
	    }
}
