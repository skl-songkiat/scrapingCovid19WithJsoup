package com.sklsongkiat.scraping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlAccess {

//	
//	CREATE TABLE report_confirm (
//		   id_report INT NOT NULL AUTO_INCREMENT,
//		   datetime_report_confirm DATETIME NOT NULL,
//		   sum_report_confirm INT(10) NOT NULL,
//		   new_report_confirm INT(10) NOT NULL,
//		   coma_report_confirm INT(10) NOT NULL,
//		   died_report_confirm INT(10) NOT NULL,
//		   gohome_report_confirm INT(10) NOT NULL,
//		   PRIMARY KEY (id_report)
//		   );
	
//	INSERT INTO report_confirm values (default,
//	'2563-03-22 12:00:00',
//	599,
//	188,
//	7,
//	1,
//	45);
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	public void readDataBase() throws Exception {
		
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_covid19?user=root&password=sklsongkiat");
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from report_confirm");
			
			System.out.println("resultSet = " + resultSet);
			writeResultSet(resultSet);
		}catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	private void writeResultSet(ResultSet resultSet)throws SQLException {
		// TODO Auto-generated method stub
		
		while(resultSet.next()) {
			
			String id_report = resultSet.getString("id_report");
			String datetime_report_confirm = resultSet.getString("datetime_report_confirm");
			String sum_report_confirm = resultSet.getString("sum_report_confirm");
			String new_report_confirm = resultSet.getString("new_report_confirm");
			String coma_report_confirm = resultSet.getString("coma_report_confirm");
			String died_report_confirm = resultSet.getString("died_report_confirm");
			String gohome_report_confirm = resultSet.getString("gohome_report_confirm");
			
			
			System.out.println("id_report = " + id_report);
			System.out.println("datetime_report_confirm = " + datetime_report_confirm);
			System.out.println("sum_report_confirm = " + sum_report_confirm);
			System.out.println("new_report_confirm = " + new_report_confirm);
			System.out.println("coma_report_confirm = " + coma_report_confirm);
			System.out.println("died_report_confirm = " + died_report_confirm);
			System.out.println("gohome_report_confirm = " + gohome_report_confirm);
			System.out.println("");
		}
		
	}
	
}
