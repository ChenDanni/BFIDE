package service.impl;

import rmi.RemoteHelper;
import service.UserService;

import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class UserServiceImpl implements UserService{
    @Override
    public boolean login(String username, String password) throws RemoteException {
        try {
            return RemoteHelper.getInstance().getUserService().login(username,password);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean logout(String username) throws RemoteException {
        return false;
    }
}
