package service.impl;

import rmi.RemoteHelper;
import service.ExecuteService;
import utility.TmpHelper;

import java.rmi.RemoteException;

/**
 * Created by cdn on 17/6/25.
 */
public class ExecuteServiceImpl implements ExecuteService {

    @Override
    public String execute(String code, String param) {
        return RemoteHelper.getInstance().getExecuteService().execute(code,param);
    }
}
