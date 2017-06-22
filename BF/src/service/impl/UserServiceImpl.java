package service.impl;

import service.UserService;

import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class UserServiceImpl implements UserService{
    @Override
    public boolean login(String username, String password) throws RemoteException {
        return false;
    }

    @Override
    public boolean logout(String username) throws RemoteException {
        return false;
    }
}
