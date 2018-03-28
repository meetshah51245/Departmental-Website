package model;

public class courseListSetGet {
	
	String id;
	String name;
	int concentration;
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
        return name;
    }
	
	public void setConcentration(int id){
		concentration = id;
	}
	
	public int getConcentration() {
        return concentration;
    }
}
