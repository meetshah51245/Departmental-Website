package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PhdDAO {
	Connection conn;
	public PhdDAO(){
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public HashMap<String, ArrayList<String>> getPhD(String net, String program){
		String sql = "select `First Name`, `Last Name`, `Program`, `Major`, `Net ID`, `Join Date` FROM `registration` WHERE `registration`.`Net ID` = '"+net+"'";
		String sql1 = "select `Contact Number`, `E-mail`, `Advisor`, `Status` FROM `addinfo` WHERE `addinfo`.`Net ID` = '"+net+"'";
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
						for(int i = 1; i <= 6;i++){
							info.add(rs.getString(i));
							cName.add(rsmd.getColumnName(i));
						}
					}
				if(flag == true){
					rs1 = s.executeQuery(sql1);
					ResultSetMetaData rsmd1 = rs1.getMetaData();
					if(rs1.next()){
						for(int i = 1; i <= 4;i++){
							String value = rs1.getString(i);
							if(!rs1.wasNull()){
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
		
	
	public HashMap<String,ArrayList<String>> Name(String program){
		
		String sql = "select `Net ID`,`First Name`, `Last Name` FROM `registration` where `Program`='"+program+"'";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<String> list = new ArrayList<>();
			ArrayList <String> list1 = new ArrayList<>();
			HashMap<String,ArrayList<String>> map = new HashMap<>();
			while(rs.next()){
				String fname = rs.getString("First Name");
				String lname = rs.getString("Last Name");
				String id = rs.getString("Net ID");
				String fullName = fname+" "+lname;
				list.add(fullName);
				list1.add(id);
			}
			map.put("list", list);
			map.put("id", list1);
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean selectQuery(String program){
		String SqlQuery = "select * from registration where `Program`='"+program+"'";
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
	
	public int updateStatus(String net, String status){
		
		String sql = null;
		if(this.selectQuery1(net) == true)
			sql = "UPDATE `addinfo` SET `Status`='"+status+"' WHERE `Net ID`='"+net+"'";
		else
			sql = "INSERT INTO `meet`.`addinfo` (`Net ID`, `Contact Number`, `E-mail`, `Advisor`, `Status`) VALUES ('"+net+"', '0000000000', '"+null+"', '"+null+"', '"+status+"')";
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(sql);
			return condition;		
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
