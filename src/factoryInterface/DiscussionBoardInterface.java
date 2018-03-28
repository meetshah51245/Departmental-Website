package factoryInterface;

import java.util.ArrayList;
import java.util.HashMap;

import model.DiscussionBoardGetSet;

public interface DiscussionBoardInterface {
	public void postQuestion(DiscussionBoardGetSet dbgs) throws Exception;
	public HashMap<String, ArrayList<String>> selectPost() throws Exception;
	public int delete(int userId);
	public boolean selectEverything();
}
