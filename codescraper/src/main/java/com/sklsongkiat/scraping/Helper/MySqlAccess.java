package com.sklsongkiat.scraping.Helper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sklsongkiat.scraping.Model.ReportConfirmModel;

public class MySqlAccess {

//	
//	CREATE TABLE report_confirm (
//		   id_report INT NOT NULL AUTO_INCREMENT,
//		   datetime_report_confirm VARCHAR(50) CHARACTER SET utf8 NOT NULL,
//		   sum_report_confirm VARCHAR(20) NOT NULL,
//		   new_report_confirm VARCHAR(20) NOT NULL,
//		   coma_report_confirm VARCHAR(20) NOT NULL,
//		   died_report_confirm VARCHAR(20) NOT NULL,
//		   gohome_report_confirm VARCHAR(20) NOT NULL,
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
    private ReportConfirmModel reportModel = null;
    
    public MySqlAccess() {
    	try {
    		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_covid19?user=root&password=sklsongkiat");
    	}catch (Exception ex){
    		System.out.println("SQLException: " + ex.getMessage());
    	}
    }
	
	public void readDataBase() throws Exception {
		
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from report_confirm");
		readResultSet(resultSet);
			
	}
	
	public void writeDataBase(ReportConfirmModel reportModel) throws Exception {
		
		this.reportModel = reportModel;
		
		preparedStatement = connect.prepareStatement
				("insert into report_confirm values(default, ?, ?, ?, ?, ?, ?)");
		insertDataSet(preparedStatement);
		
	}
	
	private void insertDataSet(PreparedStatement prepare) throws SQLException {
		prepare.setString(1, reportModel.getDate());
		prepare.setString(2, reportModel.getSummery());
		prepare.setString(3, reportModel.getNew());
		prepare.setString(4, reportModel.getComa());
		prepare.setString(5, reportModel.getDied());
		prepare.setString(6, reportModel.getGoHome());
		prepare.executeUpdate();
	}

	private void readResultSet(ResultSet resultSet)throws SQLException {
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
