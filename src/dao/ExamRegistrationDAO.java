package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExamRegistrationDAO {
	Connection conn;
	public ExamRegistrationDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public int register(String type, String name, String netId){
		String sql = "INSERT INTO `examregistration`(`Type`, `name`, `NetId`) VALUES ('"+type+"','"+name+"','"+netId+"')";
		try {
			Statement pst = conn.createStatement();
			int condition = pst.executeUpdate(sql);
			return condition;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
	}
	
	public static ExamRegistrationDAO getObject(){
		return new ExamRegistrationDAO();
	}
	
	public boolean isRegistered(String type, String name, String netId){
		String sql = "select * `examregistration` where `Type` = '"+type+"' and `name` = '"+name+"' and `NetId` = '"+netId+"'";
		try {
			Statement pst = conn.createStatement();
			ResultSet rs = pst.executeQuery(sql);
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
