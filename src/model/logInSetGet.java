package model;

public class logInSetGet {
	String user;
	String password;
	String netId;
	
	public void setUser(String user){
		this.user = user;
	}
	public String getUser(){
		return user;
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
}
