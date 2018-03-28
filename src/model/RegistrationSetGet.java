package model;

import java.util.Date;

public class RegistrationSetGet {
	
	String user;
	String firstName;
	String lastName;
	String program;
	String password;
	String netId;
	Date date; 
	String path;
	String major;
	
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
	
	public void setProgram(String email){
		program = email;
	}
	
	public String getProgram() {
        return program;
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

	
}
