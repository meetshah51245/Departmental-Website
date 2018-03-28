package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import factoryInterface.DiscussionBoardInterface;
import model.DiscussionBoardGetSet;

public class DiscussionBoardDAO implements DiscussionBoardInterface{
	
	Connection conn = null;
	public DiscussionBoardDAO() {
		makeConn makeConn = new makeConn();
		conn = makeConn.connect();
	}
	
	public void postQuestion(DiscussionBoardGetSet dbgs){
		
		Date td = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String query = "INSERT INTO `meet`.`discussion` (`ID`,`parentFeedId`, `topic`, `mainPost`, `time`) VALUES ("+null+",'"+dbgs.getPID()+"','"+dbgs.getTopic()+"','"+dbgs.getMainPost()+"','"+dt.format(td)+"')";
		
		try{
			Statement s = conn.createStatement();
			s.executeUpdate(query);	
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public HashMap<String, ArrayList<String>> selectPost(){
		
		String query = "SELECT * FROM `meet`.`discussion` order by Time DESC";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			ArrayList<String> list = new ArrayList<>();
			ArrayList<String> list1 = new ArrayList<>();
			ArrayList<String> id = new ArrayList<>();
			ArrayList<String> id1 = new ArrayList<>();
  			HashMap<String, ArrayList<String>> map = new HashMap<>();
			
			String post = null;	
			String topic = null;
			String pid = null;
			String id11 = null;
			while(rs.next()){
				post = rs.getString("mainPost");
				topic = rs.getString("topic");
				pid = rs.getString("parentFeedId");
				id11 = rs.getString("ID");
				
				list.add(post);
				list1.add(topic);
				id.add(pid);
				id1.add(id11);
			}	
			
			map.put("list1", list1);
			map.put("list", list);
			map.put("pid", id);
			map.put("id", id1);
			
			return map;	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(int postId){
		
		String query = "DELETE FROM `meet`.`discussion` WHERE `discussion`.`ID` = "+postId+"";
		try{
			Statement s = conn.createStatement();
			int condition = s.executeUpdate(query);
			return condition;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean selectEverything(){
		String query = "SELECT * FROM `meet`.`discussion`";
		try{
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()){
				if(rs.getString("parentFeedId").equals("0"))
					return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
