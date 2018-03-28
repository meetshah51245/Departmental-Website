package factoryClass;

import dao.DiscussionBoardDAO;
import factoryInterface.DiscussionBoardInterface;

public class DiscussionFactory {
	
	public DiscussionBoardInterface geDiscussion(){
		return new DiscussionBoardDAO();
	}

}
