package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import factoryInterface.userProfileInterface;
import model.editUserSetGet;

public class UserProfileDAO implements userProfileInterface {
	
	Connection conn;
	public UserProfileDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public HashMap<String, ArrayList<String>> getInfo(String net){
		String query = "SELECT * FROM `registration` where `Net ID`='"+net+"'";
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> columnName = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if(rs.next()){
				for(int i = 1; i <= 8; i++){
					list.add(rs.getString(i));
					columnName.add(rsmd.getColumnName(i));
				}
			}
			map.put("list", list);
			map.put("columnName", columnName);
			return map;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkTable(editUserSetGet eu){
		
		String sql = "select * from addinfo where `Net ID`='"+eu.getNetid()+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public HashMap<String, ArrayList<String>> getTable(String net){
		String query = "SELECT `Contact Number`, `E-mail`, `Advisor`, `Status` FROM `addinfo` where `Net ID`='"+net+"'";
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> columnName = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if(rs.next()){
				System.out.println("---For---");
				for(int i = 1; i <= 4; i++){
					System.out.println(rs.getString(i));
					list.add(rs.getString(i));
					columnName.add(rsmd.getColumnName(i));
				}
			}
			map.put("list", list);
			map.put("columnName", columnName);
			return map;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertInfo(editUserSetGet eu){
		Date td = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = "INSERT INTO `meet`.`addinfo` (`Net ID`, `Contact Number`, `E-mail`, `Advisor`, `Status`) VALUES ('"+eu.getNetid()+"', '"+eu.getContact()+"', '"+eu.getEmail()+"', '"+eu.getAdvisor()+"', '"+eu.getStatus()+"')";
		String sqlQuery = "UPDATE `registration` SET `User`='"+eu.getUser()+"',`First Name`='"+eu.getFname()+"',`Last Name`='"+eu.getLname()+"',`Program`='"+eu.getProgram()+"',`Major`='"+eu.getMajor()+"',`Net ID`='"+eu.getNetid()+"',`Birth Day`='"+dt.format(td)+"',`Password`='"+eu.getPassword()+"' WHERE `Net ID`='"+eu.getNetid()+"'";
		try {
			Statement pst = conn.createStatement();
			pst.executeUpdate(sqlQuery);
			pst.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateInfo(editUserSetGet eu){
		Date td = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = "UPDATE `addinfo` SET `Net ID`='"+eu.getNetid()+"',`Contact Number`='"+eu.getContact()+"',`E-mail`='"+eu.getEmail()+"',`Advisor`='"+eu.getAdvisor()+"',`Status`='"+eu.getStatus()+"' WHERE `Net ID`="+eu.getNetid()+"";
		String sqlQuery = "UPDATE `registration` SET `User`='"+eu.getUser()+"',`First Name`='"+eu.getFname()+"',`Last Name`='"+eu.getLname()+"',`Program`='"+eu.getProgram()+"',`Major`='"+eu.getMajor()+"',`Net ID`='"+eu.getNetid()+"',`Birth Day`='"+dt.format(td)+"',`Password`='"+eu.getPassword()+"' WHERE `Net ID`='"+eu.getNetid()+"'";
		try {
			Statement pst = conn.createStatement();
			pst.executeUpdate(sqlQuery);
			pst.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
