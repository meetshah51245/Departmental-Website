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

public class StaffProfileDAO implements userProfileInterface {
	
	Connection conn;
	public StaffProfileDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public HashMap<String, ArrayList<String>> getInfo(String net){
		
		String sql = "SELECT * FROM `staff` where `Net ID`='"+net+"'";
		String sql1 = "select `Contact Number`, `E-mail` FROM `addinfo` WHERE `addinfo`.`Net ID` = '"+net+"'";
		boolean flag = selectQuery1(net); 
		ArrayList<String> cName = new ArrayList<>();
		ArrayList<String> info = new ArrayList<>();
		try{
			ResultSet rs = null;
			ResultSet rs1 = null;
			
			Statement s = conn.createStatement();
			
				
			rs = s.executeQuery(sql);
					
			ResultSetMetaData rsmd = rs.getMetaData();
						
			if(rs.next()){
				for(int i = 1; i <= 5;i++){
					info.add(rs.getString(i));
					cName.add(rsmd.getColumnName(i));
				}
			}
			if(flag == true){
				rs1 = s.executeQuery(sql1);
				ResultSetMetaData rsmd1 = rs1.getMetaData();
				if(rs1.next()){
					for(int i = 1; i <= 2;i++){
						String value = rs.getString(i);
						if(!rs.wasNull()){
							info.add(value);
							cName.add(rsmd1.getColumnName(i));
						}
						else{
							info.add("Not Added");
							cName.add(rsmd1.getColumnName(i));
						}
					}
				}
			}
				
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			map.put("info",info);
			map.put("cName",cName);
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
	
	/*public HashMap<String, ArrayList<String>> getTable(String net){
		String query = "SELECT `Contact Number`, `E-mail` FROM `addinfo` where `Net ID`='"+net+"'";
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> columnName = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if(rs.next()){
				for(int i = 1; i <= 2; i++){					
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
	}*/
	
	public void insertInfo(editUserSetGet eu){
		String query = "INSERT INTO `meet`.`addinfo` (`Net ID`, `Contact Number`, `E-mail`, `Advisor`, `Status`) VALUES ('"+eu.getNetid()+"', '"+eu.getContact()+"', '"+eu.getEmail()+"', '"+null+"', '"+null+"')";
		String sqlQuery = "UPDATE `staff` SET `User`='"+eu.getUser()+"',`First Name`='"+eu.getFname()+"',`Last Name`='"+eu.getLname()+"',`Net ID`='"+eu.getNetid()+"',`Password`='"+eu.getPassword()+"' WHERE `Net ID`='"+eu.getNetid()+"'";
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
		String query = "UPDATE `addinfo` SET `Net ID`='"+eu.getNetid()+"',`Contact Number`='"+eu.getContact()+"',`E-mail`='"+eu.getEmail()+"' WHERE `Net ID`='"+eu.getNetid()+"'";
		String sqlQuery = "UPDATE `staff` SET `User`='"+eu.getUser()+"',`First Name`='"+eu.getFname()+"',`Last Name`='"+eu.getLname()+"',`Net ID`='"+eu.getNetid()+"',`Password`='"+eu.getPassword()+"' WHERE `Net ID`='"+eu.getNetid()+"'";
		try {
			Statement pst = conn.createStatement();
			pst.executeUpdate(sqlQuery);
			pst.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean selectQuery1(String net){
		String SqlQuery = "select * from addinfo where `Net ID`='"+net+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(SqlQuery);
			if(rs.next()){
				return true;
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
