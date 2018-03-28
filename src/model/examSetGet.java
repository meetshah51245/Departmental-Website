package model;

import java.util.Date;

public class examSetGet {
	
	String type;
	Date date; 
	String name;
	String content;
	String owner;
	
	public void setType(String type){
	 this.type = type;
	}
	public String getType(){
		return type;
	}
	
	public void setDate(Date date){
		 this.date = date;
	}
	public Date getDate(){
		return date;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setOwner(String name){
		owner = name;
	}
	public String getOwner(){
		return owner;
	}
}
