package service.impl;

import service.IOService;

import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class IOServiceImpl implements IOService{
    @Override
    public boolean writeFile(String file, String userId, String fileName) throws RemoteException {

        return false;
    }

    @Override
    public String readFile(String userId, String fileName) throws RemoteException {
        return null;
    }

    @Override
    public String readFileList(String userId) throws RemoteException {
        return null;
    }
}
