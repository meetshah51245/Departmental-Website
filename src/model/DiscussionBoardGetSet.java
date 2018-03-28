package model;

public class DiscussionBoardGetSet {
	
	String MainPost;
	String t;
	int p;
	
	public void setMainPost(String mainPost){
		MainPost = mainPost;
	}
	public String getMainPost(){
		return MainPost;
	}
	
	public void setTopic(String topic){
		t = topic;
	}
	public String getTopic(){
		return t;
	}
	
	public void setPID(int id){
		p = id;
	}
	public int getPID(){
		return p;
	}

}
