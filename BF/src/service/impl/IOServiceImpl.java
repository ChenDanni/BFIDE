package service.impl;

import rmi.RemoteHelper;
import service.IOService;

import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/22.
 */
public class IOServiceImpl implements IOService{
    @Override
    public boolean writeFile(String file, String userId, String fileName) throws RemoteException {
        try {
            RemoteHelper.getInstance().getIOService().writeFile(file, userId, fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String readFile(String userId, String fileName) throws RemoteException {
        try {
            return RemoteHelper.getInstance().getIOService().readFile(userId,fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String readFileList(String userId) throws RemoteException {

        try {
            return RemoteHelper.getInstance().getIOService().readFileList(userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String[] getVersions(String userId, String fileName) throws RemoteException {
        try {
            return RemoteHelper.getInstance().getIOService().getVersions(userId,fileName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return new String[0];
    }
}
