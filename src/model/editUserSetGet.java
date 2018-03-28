package model;

import java.util.Date;

public class editUserSetGet {
	String user;
	String firstName;
	String lastName;
	String email;
	String password;
	String netId;
	Date date; 
	String path;
	String major;
	String program;
	String status;
	Long contact;
	String advisor;
	
	public void setDate(Object object){
		date = (Date) object;
	}
	public Date getDate(){
		return date;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	public String getUser(){
		return user;
	}
		
	public void setFname(String fname){
		this.firstName = fname;
	}
	
	public String getFname() {
        return firstName;
    }
	
	public void setLname(String lname){
		this.lastName = lname;
	}
	
	public String getLname() {
        return lastName;
    }
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail() {
        return email;
    }
	
	public void setPassword(String pass){
		this.password = pass;
	}
	
	public String getPassword() {
        return password;
    }
	
	public void setNetid(String id){
		this.netId = id;
	}
	
	public String getNetid() {
        return netId;
    }
	
	public void setMajor(String user){
		major = user;
	}
	public String getMajor(){
		return major;
	}
	
	public void setProgram(String user){
		program = user;
	}
	public String getProgram(){
		return program;
	}
	
	public void setContact(Long N){
		contact = N;
	}
	public Long getContact(){
		return contact;
	}
	
	public void setStatus(String N){
		status = N;
	}
	public String getStatus(){
		return status;
	}
	
	public void setAdvisor(String N){
		advisor = N;
	}
	public String getAdvisor(){
		return advisor;
	}
}
