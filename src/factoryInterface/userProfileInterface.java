package factoryInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.editUserSetGet;

public interface userProfileInterface {
	public HashMap<String, ArrayList<String>> getInfo(String net);

	public boolean checkTable(editUserSetGet eu);

//	public HashMap<String, ArrayList<String>> getTable(String netId);

	public void insertInfo(editUserSetGet eu);

	public void updateInfo(editUserSetGet eu);
}
