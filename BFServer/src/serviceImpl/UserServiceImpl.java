package serviceImpl;

import java.rmi.RemoteException;

import service.UserService;
import utility.UserHelper;

public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String username, String password) throws RemoteException {
		String pwd = UserHelper.getPwd(username);
		if (pwd == null)
			return false;
		if (password.equals(pwd)){
			return true;
		}
		return false;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		return true;
	}

}
